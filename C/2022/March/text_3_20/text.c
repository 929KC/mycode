#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//计数器
//int my_strlen(const char*str) 
//{
//	int  count = 0;
//	while (*str)
//	{
//		str++;
//		count++;
//	}
//	return count;
//}
//int main() {
//
//
//	char arr[] = { "abcdefg" };
//	int len=my_strlen(arr);
//	printf("%d " , len);
//	return 0;
//}
////递归计算
//int my_strlen(const char*str) 
//{
//	
//	if (*str == '\0') {
//		return 0;
//	}
//	else {
//		return 1 + my_strlen(str + 1);
//	}
//}
//int main()
//{
//	char arr[] = { "abcdefg" };
//	int len = my_strlen(arr);
//	printf("%d ", len);
//
//
//	return 0;
//}
////指针-指针
//
//int my_strlen(const char*str) 
//{
//	char* ps = str;
//	while (*ps != '\0')
//	{
//		ps++;
//	}
//	return ps - str;
//}
//
//int main() 
//{
//	char arr[] = { "abcdefg" };
//	int len = my_strlen(arr);
//	printf("%d ", len);
//	return 0;
//}

//int main()
//{
//	char arr[] = { "abcdef" };
//	char arr2[] = { "abcdefsdfasd" };
//	if ((int)strlen(arr) - (int)strlen(arr2)>0)
//	{
//		printf(">");
//	}
//	else 
//	{
//		printf("<=");
//	}
//
//	return 0;
//}

//int main()
//{
//	char arr[] = { "ab" };
//	char arr2[] = { "hello bit" };
//	strcpy(arr, arr2);
//	printf("%s", arr);
//	return 0;
//}
//#include<assert.h>
//char* my_strcpy(char *dest, char*sour)
//{
//	assert(dest && sour);
//	 char* ret = dest;
//	while (*dest++= *sour++) {
//		;
//	}
//	return ret;
//}
//
//int main()
//{
//	char arr[] = { "absdfasdfasrtfsa" };
//	char arr2[] = { "hello bit" };
//	printf("%s", my_strcpy(arr, arr2));
//
//	return 0;
//}

int main()
{
	char arr[100] = { "absafasfasfas" };
	char arr2[2000] = { "hello bit"};
	strcat(arr, arr2);
	printf('%s', arr);
	return 0;
}