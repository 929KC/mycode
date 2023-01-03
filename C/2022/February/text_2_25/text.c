#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//转换小写
//
//int main()
//{
//	int ch = 0;
//	while ((ch = getchar()) != EOF)
//	{
//		putchar(ch+32);
//		getchar();
//	}
//	return 0;
//}
//void my_strcpy(char *arr2, char *arr)
//{
//	while (*arr != '\0')
//	{
//		*arr2 = *arr;
//		arr++;
//		arr2++;
//	}
// *arr2 = *arr;
//}
//#include<assert.h>
//char* my_strcpy(char* arr2,const char* arr)//char *为了实现链式访问
//{
//	assert(arr2 && arr);// 断言  避免空指针 NUll=0
//	char* ret = arr2;//首地址
//	while (*arr2++=*arr++)
//	{
//		
//	}
//	return arr2;
//	
//}
//
//
//int main()
//{
//	char arr[] = "hello world";
//	char arr2[] = "xxxxxxxxxxxxxxxxx";
//	//strcpy(arr2, arr);
//	//printf("%s", arr2);
//	my_strcpy(arr2,arr);
//	printf("%s", arr2);
//	return 0;
//}

//int my_strlen(char* arr)
//{
//	int count = 0;
//	while (*arr++!= '\0')
//	{
//		count++;
//	}
//	return count;
//}
//
//int main()
//{
//	char arr[] = "hello world";
//	int len=my_strlen(arr);
//	printf("%d", len);
//
//	return 0;
//}
//void my_resrver(char *arr)
//{
//	while()
//
//}

//int main()
//{
//
//	char arr[100];
//	scanf("%s", arr);
//	int len =strlen(arr);
//	printf("%d", len);
//	//my_resever(arr);
//	return 0;
//}
// b-
//int main()
//{
//
//	char arr[100];
//
//
//	return 0;
//}

#include<stdio.h>
#include<string.h>
void resever(char* arr,int left, int right)
{
    while (left < right)
    {
        int temp = 0;
        temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        left++;
        right--;
    }

}

int main()
{
    char  arr[100] = { 0 };     
    char  arr2[100] = { 0 };
    gets_s(arr, 100);
    int len = strlen(arr);
    resever(arr, 0, len - 1);
   // printf("%s", arr);
    for (int i=0;i<len-1;i++)
    {
        if (arr[i] == " " || arr[0] == '\0')
        {
            resever(arr,i,i+2);
           
            
        }
   }

   // resever(arr, 4, 6);


    printf("%s", arr);
    return 0;
}
