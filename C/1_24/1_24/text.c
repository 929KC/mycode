#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//    int i = 1;
//    int ret = (++i) + (++i) + (++i);                                               
//    printf("ret = %d\n", ret);
//    return 0;
//}

//int i;
//int main()
//{
//    i--;
//    if (i > sizeof(i))
//    {
//        printf(">\n");
//    }
//    else
//    {
//        printf("<\n");
//    }
//    return 0;
//}

//int main()
//{
//	int a, b, c;
//	a = 5;
//	c = ++a;
//	b = ++c, c++, ++a, a++;
//	b += a++ + c;
//	printf("a = %d b = %d c = %d\n:", a, b, c);
//	return 0;
//}
//void print(int* arr, int len)
//{
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//void reverse(int* arr,int len)
//{
//	int left = 0;
//	int right = len - 1;
//	while (left < right)
//	{
//			int temp = arr[left];
//			arr[ left] = arr[right];
//			arr[right] = temp;
//			left++;
//			right--;
//	}
//}
//
//int main() 
//{
//	int arr[] = { 212,45,78,2,6,65,7845,12 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	reverse(arr,len);
//	print(arr, len);
//}