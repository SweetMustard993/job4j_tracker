package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу бнковских переводов между счетами клиентов банка
 *
 * @author BOGDAN MAZURENKO
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в карте типа HashMap, в которой ключом
     * является объект типа User, а значением является ArrayList коллекция
     * объектов типа Account
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в карту пользователей.
     * Если запись с таким ключем уже есть в карте, то
     * пользовательне не добавляется
     *
     * @param user пользователь который добавляется в список
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и счет.
     * Если пользователь с таким паспортом есть и него нет такого счета,
     * то счет добавлется.
     *
     * @param passport паспорт пользователя
     * @param account  счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта, по нему осуществляет поиск
     * пользователя в карте пользвателей.
     *
     * @param passport паспорт пользователя
     * @return возвращает ссылку на пользователя найденого по паспорту
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход номер паспорта и реквезиты, по ним осуществляет поиск
     * счета в карте пользвателей.
     *
     * @param passport  паспорт пользователя
     * @param requisite паспорт пользователя
     * @return возвращает ссылку на найденный по пасспорту и реквизитам счет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<List<Account>> userAccounts = Optional.ofNullable(users.get(findByPassport(passport).orElse(null)));
        if (userAccounts.isPresent()) {
            return userAccounts.get().stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод принимает на вход номер паспорт, реквезиты отправителя и пасспорт и реквезиты получателя.
     * По паре парметров отправителя осуществляет поиск пользоваетеля.
     * По паре парметров получаетелся осуществляет поиск пользоваетеля.
     * Проверяет наличие счетов пользователй и достаточной суммы для перевода на счету отправителя.
     * Если денег  достаточно, с баланса отправителя вычитает сумму перевода,
     * прибавляет сумму перевода на счет получателя.
     *
     * @param srcPassport   паспорт отправителя
     * @param srcRequisite  реквизиты отправителя
     * @param destPassport  паспорт отправителя
     * @param destRequisite реквизиты отправителя
     * @return возвращает истину еси перевод удался, ложь если перевод не удалось выполнить
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> scrAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (scrAccount.isPresent() && destAccount.isPresent() && scrAccount.get().getBalance() >= amount) {
            scrAccount.get().setBalance(scrAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}