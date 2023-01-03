#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main() {
//	//链式访问：把一个函数从的返回值作为另一个函数的参数、
//	printf("%d", printf("%d", printf("%d", 43)));
//	//printf的返回值为输出字符的数量
//	return 0;
//}
//int binary_search(int arr[],int k, int sz) {
//	int left = 0;
//	int right = sz - 1;
//	while (left <= right) {
//		int mid = (left + right) / 2;
//		if (arr[mid] < k) {
//			left = mid + 1;
//		}
//		else if (arr[mid] > k) {
//			right = mid - 1;
//		}
//		else {
//			return mid;
//		}
//	}
//
//}
//
//int main() {
//	//写一个函数，实现一个整形有序数组的二分查找的
////在一个有序数组中查找具体的个数
////如果找到了返回，这个数的下标，找不到的返回-1
//	int arr []  = { 1,2,3,4,5,6,7,8,9,10 };
//	int k = 4;
//	////传过去的是数组arr首元素的地址
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	int ret = binary_search(arr, k, sz);
//	if (ret == -1) {
//		printf("找不到指定的数字\n");
//	}
//	else {
//		printf("找到了，下标是：%d\n", ret);
//	}
//	return 0;
//}
//int main() {
//
//	int a = 10;
//	int b = 20;
//	int z=Add(a, b);
//	printf("%d\n", z);
//	return 0;
//}