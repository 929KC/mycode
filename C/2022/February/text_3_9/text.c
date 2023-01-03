#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>


//int main()
//{
//	int money = 0;
//	scanf("%d", &money);
//	int total = money;
//	int empty = money/2;
//
//	while (empty >= 2) 
//	{
//		total += (empty / 2);
//		empty = empty/2 + empty % 2;
//	}
//	printf("%d\n", total);
//	return 0;
//}

//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int d = 0;
//	int e = 0;
//
//	for (int a = 0; a <= 5; a++)
//	{
//		for (int b = 0; b <=5; b++)
//		{
//			for (int c = 0; c <=5; c++)
//			{
//				for (int d = 0;d <= 5; d++)
//				{
//					for (int e = 0; e <= 5; e++)
//					{
//						if ((a == 3) + (b == 2) == 1 &&
//							(e == 4) + (b == 2) == 1 && 
//							(c== 1) + (d == 2) == 1 &&
//							(c == 5) + (d == 3) == 1&&
//							(e==4)+(a==1)==1)
//						{
//							if (a * b * c * d * e == 120)
//							{
//								printf("%d %d %d %d %d", a, b, c, d, e);
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//	return 0;
//}

//int main()
//{
//	int  killer = 0;
//
//	for (killer = 'a'; killer <= 'd'; killer++)
//	{
//		if ((killer != 'a') + (killer == 'c') + (killer =='d') + (killer != 'd') == 3)
//		{
//			printf("%c\n", killer);
//		}
//	}
//
//
//	return 0;
//}


//int main()
//{
//
//	myz_
//	return 0;
//}
//void move(int arr[],int  len)
//{
//	int left = 0;
//	int right = len - 1;
//
//	while(left<right)
//	{
//
//		while ((left < right)&&(arr[left]%2==1))
//		{
//			left++;
//		}
//
//		while (left < right&&(arr[right]%2==0))
//		{
//			right--;
//		}
//
//			if (left < right)
//			{
//				int tmp = arr[left];
//				arr[left] = arr[right];
//				arr[right] = tmp;
//			}
//		
//	}
//}
//void print(int arr[],int len)
//{
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	move(arr, len);
//	print(arr, len);
//	return 0;
//}
int my_strlen(char const *ch)
{
	int count = 0;
	while ((*ch) != '\0')
	{
		count++;
		ch++;
	}
	return  count;
}

int main()
{
	int len=my_strlen("abvdef");
	printf("%d\n", len);
	return 0;
}