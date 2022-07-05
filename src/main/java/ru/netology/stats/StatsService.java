package ru.netology.stats;

public class StatsService {
    //Сумма всех продаж
    public long sum(long[] sales) {
        int sum = 0;
        for (long sale : sales) {
            sum += sale;

        }
        return sum;
    }

    //Средняя сумма продаж в месяц
    public long average(long[] sales) {
        return sum(sales) / 12;
    }

    //Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)
    public long maxSales(long[] sales) {

        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[maxMonth] - продажи в месяце maxMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    //Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)
    public long minSales(long[] sales) {

        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month - 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth - 1;
    }


    //Кол-во месяцев, в которых продажи были ниже среднего
    public int countBelowAvg(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale < avg) {
                count++;
            }
        }
        return count;
    }

    //Кол-во месяцев, в которых продажи были выше среднего
    public int countAboveAvg(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale > avg) {
                count++;
            }
        }
        return count;
    }
}