#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//char * my_strcat( char *dest,  char *sour)
//{
//	char* ps = dest;
//	//—∞’“\0
//
//	while (*dest) 
//	{
//		dest++;
//	}
//	//øΩ±¥
//	while (*dest++ = *sour++)
//	{
//		;
//	}
//	return ps;
//}
//int main()
//{
//	char arr1[20] = {"abcdefg"};
//	char arr2[20] = " bit";
//	printf("%s\n", strcat(arr2, arr2));
//	return 0;
//}
//int main()
//{
//
//	char arr[] = { "abcdef" };
//	char arr2[] = {"abcd"}
//	strc
//	return 0;
//}

//int main()
//{
//	char arr[20] = { "bit" };
//	strcat(arr, arr);
//	printf("%s", arr);
//	return 0;
//}
//#include<assert.h>
//char* my_strcmp(char *dest,char *str)
//{
//	assert(dest && str);
//	while (*dest==*str)
//	{
//		if (*dest == '\0')
//		{
//			return 0;
//		}
//		dest++;
//		str++;
//	}
//	if (*dest > *str)
//	{
//		return 1;
//	}
//	else {
//		return -1;
//	}
//}
//int main()
//{
//	char arr[] = { "abcde" };
//	char arr2[] = { "abcdef" };
//	printf("%d", my_strcmp(arr, arr2));
//	return 0;
//}

//int main()
//{
//	char arr[] = { "abcd\0xxxx" };
//	char arr2[] = { "def" };
//	strncat(arr, arr2,10);
//	printf("%s", arr);
//	return 0;
//}
int main()
{
	char arr[] = "abcde";
	char arr2[] =  "abcdef";
	size_t len=strlen(arr);
	int len2 = strlen(arr2);
	printf("%d\n", len2);
	printf("%d\n", len);
	return 0;
}
//printf("%d\n", len);
//if ((strlen(arr) - strlen(arr2) > 0))
//{
//	printf(">");
//}
//else
//{
//	printf("<");
//}