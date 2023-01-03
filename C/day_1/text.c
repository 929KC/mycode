#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<String.h>
//int main() {
//	char arr[] = { 'a','b','c' };//a,b,c,~~~~~\0截止
//	printf("%d\n", strlen(arr));
//	char arr2[5] = "abc";//后面默认有\0
//	char arr3  [] = "abcdef";//后面默认有\0,根据后面的内容确定数组的大小，数组大小为7
//	char arr4[] = { 'a','b','c','\0'};
//	int arr5[5] = { 1,2,3,4,56};
//	int len1 = sizeof(arr5) / sizeof(arr5[0]);
//	for (int i = 0; i < len1;i++ ) {
//		printf("%d \n", arr5[i]);
//
//	}
//	printf("**********\n");
//	int len = strlen(arr4);
//	for (int i = 0; i < len; i++) {
//		printf("%c\n", arr4[i]);
//	}
//	printf("%d\n", sizeof(arr3));
//	sizeof计算的 arr3所占空间的大小
//	7个char- 7*1（1指字符所占空间大小）
//	printf("%d\n", strlen(arr3));
//	strlen求字符串的长度，'\0'只求、0之前的字符串个数
//	[a b c d e f \0]
//	6
//	1.strlen和sizeof没有什么关联
//	2.strlen是求字符串长度-只能求字符串长度-库函数-使用的引头文件
//	3.sizeof计算变量，类型的大小-单位是字节-操作符
//	数组在内存一中是连续存放的，低地址->高地址
//
//
//
//	return 0;
//}
//int main() {
//	int arr[2][4] = { {1,2,3,43},{3,4,5,6} };
//	int arr2[] [4]= { {1,2,3,43},{3,4,5,6} };//行可剩列不可省
//	int arr2[2][] = { {1,2,3,43},{3,4,5,6} };
//	return 0;
//}
//冒泡排序
//void bouble_sort(int *arr,int sz) 
//{
//	
//	for (int i = 0; i < sz; i++)
//	{
//		int flag = 1;//假设已经有序了
//		for (int j = 0; j < sz - i - 1; j++)
//		{
//			if (arr[i] > arr[i + 1])
//			{
//				int temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//				flag = 0;//本次排序的数据其实并没有排序
//			}
//
//		}
//		if (flag == 1)
//		{
//			break;
//
//		}
//	}
//	
//}
//int main() 
//{
//	int  arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	bouble_sort(arr, sz);//数组作为参数，传过去的其实是首元素的地址
//	for (int i = 0; i < sz; i++) {
//		printf("%d ", arr[i]);
//	}
//	return 0;
// }
//int main()
//{
//	//1。sizeof数组名-数组名表示整个数组-sizeof{数组名}计算的是整个数组的大小，但单位字节
//	//2.&数组名，代表整个数组，取得是整个数组的地址
//	int arr[] = { 1,2,4,6 };
//	printf("%d\n", sizeof(arr));
//	printf("%p\n", &arr);//打印地址用p
//	printf("%p\n", &arr+1);
//	printf("%p\n", &arr[0]);
//	printf("%p\n", &arr[0]+1);
//	printf("%p\n", &arr);
//	printf("%p\n", &arr + 1);
//	printf("%d\n", *arr);
//	//&arr虽然地址也是首元素的地址，但是其意义不和前面的一致
//	//数组名就是首元素的地址
//	//16187028
//	//16187028
//
//}
////int main()
////{
////
////	return 0;
////}