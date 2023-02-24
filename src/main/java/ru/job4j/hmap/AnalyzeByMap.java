package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0.0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            res.add(new Label(pupil.name(), sum / count));
        }
        return res;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.computeIfPresent(subject.name(), (k, v) -> v + subject.score());
                map.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(new Label(key, map.get(key) / pupils.size()));
        }
        return res;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            res.add(new Label(pupil.name(), sum));
        }
        res.sort(Comparator.naturalOrder());
        return res.get(res.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.computeIfPresent(subject.name(), (k, v) -> v + subject.score());
                map.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(new Label(key, map.get(key)));
        }
        res.sort(Comparator.naturalOrder());
        return res.get(res.size() - 1);
    }
}