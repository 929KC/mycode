#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

//int main()
//{
//	FILE* pf = fopen("text.txt", "r");
//	if (pf == NULL)
//	{
//		perror("fopen:");
//		return 1;
//	}
//	else {
//		printf("OK \n");
//	}
//
//	for (int i = 'A' ; i <= 'Z'; i++)
//	{
//		fputc(i, pf);
//	}
//	int ch = 0;
//	while ((ch = fgetc(pf)) != EOF) {
//		printf("%c ", ch);
//	}
//	pf = NULL;
//	return 0;
//}

//int main()
//{
//	FILE* pf = fopen("text.txt", 'w');
//	if (pf == NULL)
//	{
//		perror("fopen:");
//		return 1;
//	}
//	char arr [] = "hello world";
//	fputs(arr, pf);
//	/*fgets(arr, 6, pf);
//	printf("%s ", arr);*/
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}

//int main()
//{
//	FILE* pf = fopen("data.txt", "w");
//	if (pf == NULL)
//	{
//		perror("fopen");
//		return 1;
//	}
//	struct S s = { 19,190,"Ò¶×ÓÇï"};
//	fprintf(pf, "%d %d %s", s.age, s.height, s.arr);
//	
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}
//struct S
//{
//	int age;
//	int height;
//	char arr[20];
//};
//int main()
//{
//	FILE* pf = fopen("data.txt", "rb");
//	if (pf == NULL)
//	{
//		perror("fopen");
//		return 1;
//	}
//	struct S s = { 19,190,"Ò¶×ÓÇï"};
//	fread(&s, 1, sizeof(struct S), pf);
//	printf("%d %d %s", s.age, s.height, s.arr);
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}

//int main()
//{
//	FILE* pFile = fopen("text.txt", "r");
//	
//	if (pFile == NULL)
//	{
//		perror("pFile:");
//		return 1;
//	}
//
//	fputc('a', pFile);
//	fputc('b', pFile);
//	fputc('c', pFile);
//	fputc('d', pFile);
//	int ch = 0;
//	fseek(pFile, 2, SEEK_SET);
//	ch = fgetc(pFile);
//	printf("%c\n", ch);
//	int index = ftell(pFile);
//	printf("%d ", index);
//	rewind(pFile);
//	int index2 = ftell(pFile);
//	printf("%d", index2);
//	fclose(pFile);
//	pFile = NULL;
//	return 0;
//}
#include<assert.h>
#include<ctype.h>
#include<limits.h>
enum Status
{
	VALID,
	INVALID
}status= INVALID;
int my_atio(char* str)
{
	
	assert(str);
	if (*str == '\0')
	{
		return 0;
	}

	while (isspace(*str)) 
	{
		str++;
	}

	int flag = 1;
	if (*str == '+')
	{
		flag = 1;
		str++;
	}else if (*str == '-')
	{
		flag = -1;
		str++;
	}
	
	long long n = 0;
	while (*str!='\0')
	{
		if (isdigit(*str))
		{
			n = n*10 + flag * (*str - '0');
			if (n > INT_MAX || n< INT_MIN)
			{
				if (flag == 1)
				{
					return INT_MAX;
				}
				else if (flag == -1)
				{
					return INT_MIN;
				}
				break;
			}
		}
		else
		{
			break;
		}
		str++;
	}
	if (*str == '\0')
	{
		status = VALID;
	}
	return (int)n;
}
int main()
{
	char arr [1000] = "11111111111111111513";
	int ret=my_atio(arr);
	if (status==VALID)
	{
		printf("×Ö·û´®ºÏ·¨£º%d ", ret);
	}
	else 
	{
		printf("×Ö·û´®·Ç·¨£º%d ", ret);
	}
	return 0;
}5