#define _CRT_SECURE_NO_WARNINGS 1
#include<string.h>
#include<stdio.h>

void reseve(char* str, int left, int right)
{
    while (left < right)
    {
        char ch = str[left];
        str[left] = str[right];
        str[right] = ch;
        left++;
        right--;
    }
}

int main()
{
    char arr[100] = { 0 };
    gets_s(arr,100);
    int len = strlen(arr);
    reseve(arr, 0, len - 1);
 
    
    int temp = 0;
    for (int i = 0; i < len + 1; i++)
    {
        if (arr[i] == ' ' || arr[i] == 0)
        {
            reseve(arr, temp, i - 1);
            temp = i + 1;
        }
    }

    printf("%s", arr);
    return 0;
}

//int main()
//{
//	char arr[100] = { 0 };
//	gets_s(arr, 100);
//	printf("%s", arr);
//
//	return 0;
//}
