#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//    int a = 0;
//    int b = 2;
//    if (a == 1)
//        if (b == 2)
//            printf("hehe\n");
//        else
//            printf("haha\n");
//    return 0;
//}
//int main()
//{
//    int day = 1;
//    switch (day)
//    {
//        case 1:
//            printf("����һ\n");
//            break;
//        case 2:
//            printf("���ڶ�\n");
//            break;
//        case 3:
//            printf("������\n");
//            break;
//        case 4:
//            printf("������\n");
//            break;
//        case 5:
//            printf("������\n");
//            break;
//        case 6:
//            printf("������\n");
//            break;
//        case 7:
//            printf("������\n");
//            break;
//    }
//    return 0;
//}

int  main()
{
    
    
        int day = 1;
        switch (day)
        {
            case 1: 
            case 2:
            case 3:
            case 4:
            case 5:
                printf("weekday\n");
                break;
            case 6:
            case 7:
                printf("weekend\n");
                break;
        }
        return 0;

    
}