#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//	int arr[] = { 73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33 };
//	for (int i = 0; i < 12; i++)
//	{
//		printf("%c", arr[i]);
//	}
//	return 0;
//}
//´óÐ¡Ð´×ª»»
//int main()
//{
//	char word;
//	while (scanf("%c", &word) != EOF) 
//	{
//		getchar();
//		printf("%c", word + 32);
//
//	}
//	return 0;
//}

//int main()
//{
//	int number = 0;
//	scanf("%d", &number);
//	if (number >= 0 && number < 12)
//	{          
//		printf("2");
//	}
//	if (number >= 12)                      
//		int sum =(number / 12)*6;
//		printf("%d",sum);
//	}
//	return 0;
//}
int main()
{
	int a = 0;
	int b = 0;
	int m = 0;
	scanf("%d %d", &a, &b);
	while (m = a % b)
	{
		a = b;
		b = m;
	}
	printf("%d\n", b);

	return 0;
}
