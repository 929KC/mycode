#define _CRT_SECURE_NO_WARNINGS 1
#include<math.h>
#include <stdio.h>
//int main()
//{
//	int num = 0;
//	scanf("%d\n", &num);
//	int number = pow(2, num);
//	printf("%d", number);
//
//	return 0;
//}

#include <stdio.h>      /* printf */
#include <stdlib.h>     /* qsort */



//int compare(const void* a, const void* b)
//{
//    return (*(int*)a - *(int*)b);
//}
//
//int main()
//{
//
//    int n;
//    int values[] = { 0 };
//    while (scanf("%d", values) != -1) {
//        qsort(values, 6, sizeof(int), compare);
//        for (n = 0; n < 6; n++)
//            printf("%d ", values[n]);
//    }
//    
//    return 0;
//}
//#include <stdio.h>
//int main()
//{
//	int sores[7] = { 0 };
//	
//	for (int i = 0; i < 7; i++)
//	{
//		scanf("%d", &sores[i]);
//	}
//
//	int len = sizeof(sores) / sizeof(sores[0]);
//	
//
//	for (int i = 0; i <=len-1; i++)
//	{
//		for (int j = 0; j < len - 1 - i; j++)
//		{
//			if (sores[j] > sores[j + 1])
//			{
//				int tmp = 0;
//				tmp = sores[j];
//				sores[j] = sores[j+1];
//				sores[j+1] = tmp;
//			}
//		}
//	}
//
//	int sum = 0;
//	for (int k = 0; k < 7; k++)
//	{
//	
//		sum += sores[k];
//	}
//	double average =(double)(sum - sores[0] - sores[6]) / 5;
//	printf("%.2f", average);
//	return 0;
//}
#include <stdio.h>
//int main()
//{
//	int arr []= { 31,29,31,30,31,30,31,31,30,31,30,31 };//闰年
//	int year = 0;
//	int month = 0;
//	int day = 0;
//	while (scanf("%d %d\n",&year,&month)!= -1)
//	{
//		if (year%100!=0&&year%4==0||year%400==0)
//		{
//			switch (month)
//			{
//			case 1:
//				day = 31;
//				printf("%d", day);
//				break;
//			case 2:
//				day = 29;
//				printf("%d", day);
//				break;
//			case 3:
//				day = 31;
//				printf("%d", day);
//				break;
//			case 4:
//				day = 30;
//				printf("%d", day);
//				break;
//			case 5:
//				day = 31;
//				printf("%d", day);
//				break;
//				day = 30;
//				printf("%d", day);
//				break;
//			case 6:
//			case 7:
//				day = 31;
//				printf("%d", day);
//				break;
//			case 8:
//				day = 31;
//				printf("%d", day);
//				break;
//			case 9:
//				day = 30;
//				printf("%d", day);
//				break;
//			case 10:
//				day = 31;
//				printf("%d", day);
//				break;
//			case 11:
//				day = 30;
//				printf("%d", day);
//				break;
//			case 12:
//				day = 31;
//				printf("%d", day);
//				break;
//			default:
//				printf("你输入的有误！");
//			}
//		}
//		
//	
//	}
//	return 0;
//}
//int arr[] = { 31,28,31,30,31,30,31,31,30,31,30,31 };//平年
//int arr[] = { 31,29,31,30,31,30,31,31,30,31,30,31 };//闰年
#include <stdio.h>
//int main()
//{
//	int month = 0;
//	int year = 0;
//	while (scanf("%d %d", &year, &month) != EOF)
//	{
//		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) 
//		{
//			printf("31\n");
//		}
//
//		if (month == 4 || month == 6 || month == 9 || month == 11)
//		{
//			printf("30\n");
//		}
//
//		if (month == 2)
//		{
//			if ((year % 100 != 0 && year % 4 == 0 || year % 400 == 0))
//			{
//				printf("29\n");
//			}
//			else {
//				printf("28\n");
//			}
//		}
//	
//	}
//	return 0;
//}

//int main()
//{
//	char ch;
//	while (scanf("%c\n", &ch) != EOF)
//	{
//		if (ch > 'A' && ch < 'Z' || ch>'a' && ch< 'z')
//		{
//			printf("YES\n");
//		}
//		else {
//			printf("NO\n");
//		}
//	}
//
//
//	return 0;
//}

//#include <stdio.h>
//int main()
//{
//	for (int i = 10000; i < 100000; i++)
//	{
//		if (i ==(((i % 10)* (i / 10)) + ((i % 100)* (i / 100))+ ((i % 1000) * (i / 1000)) + ((i / 10000) * (i % 10000))))
//		{
//			printf("%d ",i);
//		}
//	
//	}
//
//	return 0;
//}

int main()
{

	for(int i=0;)

	return 0;
}                             