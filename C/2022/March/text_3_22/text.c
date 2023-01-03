#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
///*int main()
//{
//	char arr[] = { 'a','c','c' };
//	char arr2[] = { 'a','a','a'};
//	printf("%s", strcpy(arr, arr2));
//	ret*/urn 0;
//}
//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	char arr[] = { "abc" };
//	char arr2[] = { "lkjjfg" };
//	printf("%s", strcpy(arr, arr2));
//	return 0;
//}

//#include<assert.h>
//int my_strcmp(char *dest,char *str)
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
//	char arr[20] = "abcde";
//	char arr2[] = "abcdef";
//	printf("%d", my_strcmp(arr, arr2));
//	return 0;
//
//char * my_strcat( char *dest,  char *sour)
//{
//	char* ps = dest;
//	while (*dest) 
//	{
//		dest++;
//	}
//	while (*dest++ = *sour++)
//	{
//		;
//	}
//	return ps;
//}
//int main()
//{
//	char arr1[20] = "abcdefg";
//	char arr2[] = " bit";
//	printf("%s\n", my_strcat(arr1, arr2));
//}
//



////计数器
//int my_strlen(const char* str)
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
//	int len = my_strlen(arr);
//	printf("%d ", len);
//	return 0;
//}

#include<assert.h>
char* my_strcpy(char *dest, char*sour)
{
	assert(dest && sour);
	 char* ret = dest;
	while (*dest++= *sour++) {
		;
	}
	return ret;
}

int main()
{
	char arr[] = { "absdfasdfasrtfsa" };
	char arr2[] = { "hello bit" };
	printf("%s", my_strcpy(arr, arr2));

	return 0;
}















//#include<assert.h>
//char* my_strcpy( char *dest, char*sour)
//{
//	assert(dest && sour);
//	 char* ret = dest;
//	while (*dest++= *sour++) {
//		;
//	}
//	return ret;
//}
//int main()
//{
//	char arr[] = { "absdfasdfasrtfsa" };
//	char arr2[] = { "hello bit" };
//	printf("%s", my_strcpy(arr2, arr2));
//	return 0;
//}

//int main()
//{
//	char arr[20] =  "abcdef" ;
//	char arr2[] =  "abdd" ;
//	printf("%s", strcat(arr, arr2));
//	return 0;
//}


//int main()
//{
//	char arr[] = "abcd";
//	char arr2[] = "abcdef";
//	printf("%d", strcmp(arr, arr2));
//	return 0;
//}

//int main()
//{
//
//	char arr[] = "xxxxxxxxxxxxxx";
//	char arr2[] = "fyfydg";
//	printf("%s", strncpy(arr, arr2, 3));
//	return 0;
//}
//int main()
//{
//	char arr[10] = "asdg";
//	char arr2[] = "adsg";
//	printf("%d", strncmp(arr, arr2, 2));
//	return 0;
//}

//int main()
//{
//	char str[] = "This is a simple string";
//	char* pch;
//	pch = strstr(str, "simple");
//	strncpy(pch, "sample", 6);
//	puts(str);
//	return 0;
//}

//#include<string.h>
//#include<stdio.h>
//#include<assert.h>
//char* my_strstr(const char* str1,const char* str2)
//{
//	assert(str1 && str2);
//	const char* s1 = str1;
//	const char* s2 = str2;
//	const char* cur = str1;
//	while (*cur)
//	{
//		s1 = cur;
//		s2 = str2;
//		while (*s1&&*s2&&(*s1 == *s2))
//		{
//			s1++;
//			s2++;
//		}
//		cur++;
//		if (*s2 == '\0')
//		{
//			return (char*)cur;
//		}
//	}
//
//	return NULL;
//}
//int main()
//{
//	char arr [] = "abcabc";
//	char arr2[] = "abc";
//	char* ret = my_strstr(arr, arr2);
//	if (ret != NULL)
//	{
//		printf("找到了");
//	}
//	else 
//	{
//		printf("没有找到");
//	}
//	return 0;
//}
//
