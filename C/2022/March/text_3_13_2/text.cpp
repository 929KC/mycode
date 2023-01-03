
#define _CRT_SECURE_NO_WARNINGS 
//#include<stdio.h>
//int main()
//{
//    int arr[10] = { 1,2,3,4,5,6,7,8,9,0 };
//    int(*p)[10] = &arr;//把数组arr的地址赋值给数组指针变量p
//    for (int i = 0; i < 10; i++)
// #include <stdio.h>
//   {
//        printf("%d ", *(*p+i));
//    }
//    return 0;
//}

#include <stdio.h>
void print_arr1(int arr[3][5], int row, int col)
{
    int i = 0;
    for (i = 0; i < row; i++)
    {
        int j = 0;
        for (j = 0; j < col; j++)
        {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}
void print_arr2(int(*arr)[5], int row, int col)
{
    int j = 0;
    int i = 0;
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
        {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int arr[3][5] = { 1,2,3,4,5,6,7,8,9,10 };
    print_arr1(arr, 3, 5);
    print_arr2(arr, 3, 5);
    return 0;
}
