package com.lisovski;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        int numOfTasks = 1;//хотя бы 1 задача в олимпиаде есть

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число задач в олимпидае:");
        numOfTasks = scanner.nextInt();
        int[] timeOnOneTask = new int[numOfTasks];//массив длительностей решения каждой задачи
        for (int i = 0; i < numOfTasks; i++)
        {
            System.out.println("Введите введите кол-во минут на решение задачи номер: " + (i + 1));/* +1 для корректной
            нумерации задач*/
            timeOnOneTask[i] = scanner.nextInt();
        }

        //процесс решения задач у пятикурсника:
        int penaltyTimeFifthCourse = 0;//штрафное время пятикурсника
        int firstSlag = timeOnOneTask.length * timeOnOneTask[0];
        int step=1;//счетчик цикла
        int sum=0;
        while ((timeOnOneTask.length-step)>0)
        {
            sum += (timeOnOneTask.length-step)*timeOnOneTask[step];//сумма штрафных минут
            step++;
        }
        penaltyTimeFifthCourse = firstSlag + sum;
        System.out.println("Штрафное время пятикурсника: " + penaltyTimeFifthCourse + " мин");
        //процесс решения задач у третьекурсника:
        int penaltyTimeThirdCourse = 0;//штрафное время третьекурсника
        firstSlag = timeOnOneTask.length * timeOnOneTask[timeOnOneTask.length-1];
        step=1;//счетчик цикла
        sum=0;
        while ((timeOnOneTask.length-step)>0)
        {
            sum += (timeOnOneTask.length-step)*timeOnOneTask[timeOnOneTask.length-(++step)];//сумма штрафных минут
        }
        penaltyTimeThirdCourse = firstSlag + sum;
        System.out.println("Штрафное время третьекурсника: " + penaltyTimeThirdCourse + " мин");

        //процесс решения задач у первокурсника:
        //1. Сортировка массива
        for(int i = timeOnOneTask.length-1 ; i > 0 ; i--)
        {
            for(int j = 0 ; j < i ; j++)
            {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
            if( timeOnOneTask[j] > timeOnOneTask[j+1] )
                {
                int tmp = timeOnOneTask[j];
                timeOnOneTask[j] = timeOnOneTask[j+1];
                timeOnOneTask[j+1] = tmp;
                }
            }
        }
        //2. Находим штрафное время первокурсника:
        int penaltyTimeFirstCourse = 0;//штрафное время первокурсника
        firstSlag = timeOnOneTask.length * timeOnOneTask[0];
        step=1;//счетчик цикла
        sum=0;
        while ((timeOnOneTask.length-step)>0)
        {
            sum += (timeOnOneTask.length-step)*timeOnOneTask[step];//сумма штрафных минут
            step++;
        }
        penaltyTimeFirstCourse = firstSlag + sum;
        System.out.println("Штрафное время первокурсника: " + penaltyTimeFirstCourse + " мин");

        //находим наименьшее штрафное время среди трех студентов и определяем победителя олимпиады:
        if ((penaltyTimeFirstCourse<penaltyTimeThirdCourse)&&(penaltyTimeFirstCourse<penaltyTimeFifthCourse))
        {
            System.out.println("Побеждает первокурсник!");
        }
        else if ((penaltyTimeThirdCourse<penaltyTimeFirstCourse)&&(penaltyTimeThirdCourse<penaltyTimeFifthCourse))
        {
            System.out.println("Побеждает третьекурсник!");
        }
        else if ((penaltyTimeFifthCourse<penaltyTimeFirstCourse)&&(penaltyTimeFifthCourse<penaltyTimeFifthCourse))
        {
            System.out.println("Побеждает пятикурсник!");
        }
        else if ((penaltyTimeFirstCourse==penaltyTimeThirdCourse)&&(penaltyTimeThirdCourse<penaltyTimeFifthCourse))
        {
            System.out.println("Третьекурсник уступает победу первокурснику!");
        }
        else if ((penaltyTimeThirdCourse==penaltyTimeFifthCourse)&&(penaltyTimeFifthCourse<penaltyTimeFirstCourse))
        {
            System.out.println("Пятикурсник уступает победу третьекурснику!");
        }
        else if ((penaltyTimeFirstCourse==penaltyTimeFifthCourse)&&(penaltyTimeFifthCourse<penaltyTimeThirdCourse))
        {
            System.out.println("Пятикурсник уступает победу первокурснику!");
        }
        else if ((penaltyTimeFifthCourse==penaltyTimeFirstCourse)&&(penaltyTimeFifthCourse==penaltyTimeThirdCourse))
        {
            System.out.println("Пятикурсник и третьекурсник уступают победу первокурснику!");
        }
    }
}
