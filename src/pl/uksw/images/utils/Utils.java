package pl.uksw.images.utils;

import java.util.Comparator;
import java.util.List;

public class Utils {

    public static Integer findMin(List<Integer> list)
    {
        return list.stream()
                .min(Comparator.naturalOrder())
                .get();
    }
    public static Integer findMax(List<Integer> list)
    {
        return list.stream()
                .max(Comparator.naturalOrder())
                .get();
    }
}
