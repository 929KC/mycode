#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<String.h>
//int main() {
//	char arr[] = { 'a','b','c' };//a,b,c,~~~~~\0��ֹ
//	printf("%d\n", strlen(arr));
//	char arr2[5] = "abc";//����Ĭ����\0
//	char arr3  [] = "abcdef";//����Ĭ����\0,���ݺ��������ȷ������Ĵ�С�������СΪ7
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
//	sizeof����� arr3��ռ�ռ�Ĵ�С
//	7��char- 7*1��1ָ�ַ���ռ�ռ��С��
//	printf("%d\n", strlen(arr3));
//	strlen���ַ����ĳ��ȣ�'\0'ֻ��0֮ǰ���ַ�������
//	[a b c d e f \0]
//	6
//	1.strlen��sizeofû��ʲô����
//	2.strlen�����ַ�������-ֻ�����ַ�������-�⺯��-ʹ�õ���ͷ�ļ�
//	3.sizeof������������͵Ĵ�С-��λ���ֽ�-������
//	�������ڴ�һ����������ŵģ��͵�ַ->�ߵ�ַ
//
//
//
//	return 0;
//}
//int main() {
//	int arr[2][4] = { {1,2,3,43},{3,4,5,6} };
//	int arr2[] [4]= { {1,2,3,43},{3,4,5,6} };//�п�ʣ�в���ʡ
//	int arr2[2][] = { {1,2,3,43},{3,4,5,6} };
//	return 0;
//}
//ð������
//void bouble_sort(int *arr,int sz) 
//{
//	
//	for (int i = 0; i < sz; i++)
//	{
//		int flag = 1;//�����Ѿ�������
//		for (int j = 0; j < sz - i - 1; j++)
//		{
//			if (arr[i] > arr[i + 1])
//			{
//				int temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//				flag = 0;//���������������ʵ��û������
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
//	bouble_sort(arr, sz);//������Ϊ����������ȥ����ʵ����Ԫ�صĵ�ַ
//	for (int i = 0; i < sz; i++) {
//		printf("%d ", arr[i]);
//	}
//	return 0;
// }
//int main()
//{
//	//1��sizeof������-��������ʾ��������-sizeof{������}���������������Ĵ�С������λ�ֽ�
//	//2.&�������������������飬ȡ������������ĵ�ַ
//	int arr[] = { 1,2,4,6 };
//	printf("%d\n", sizeof(arr));
//	printf("%p\n", &arr);//��ӡ��ַ��p
//	printf("%p\n", &arr+1);
//	printf("%p\n", &arr[0]);
//	printf("%p\n", &arr[0]+1);
//	printf("%p\n", &arr);
//	printf("%p\n", &arr + 1);
//	printf("%d\n", *arr);
//	//&arr��Ȼ��ַҲ����Ԫ�صĵ�ַ�����������岻��ǰ���һ��
//	//������������Ԫ�صĵ�ַ
//	//16187028
//	//16187028
//
//}
////int main()
////{
////
////	return 0;
////}