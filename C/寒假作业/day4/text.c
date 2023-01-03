#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int i;
//void prt()
//{
//	for (i = 5; i < 8; i++)
//		printf("%c", '*');
//	printf("\t");
//}
//int main()
//{
//	for (i = 5; i <= 8; i++)
//		prt();
//
//	return 0;
//}

//int main()
//{
//
//	int a = 3;
//	printf("%d\n", (a += a -= a * a));
//	return 0;
//
//}

//#include<stdio.h>
//int main()
//{
//	int num = 0;
//
//	while (scanf("%d", &num) != EOF)
//	{
//		int count = 0;
//		float sum = 0;
//		int k = 0;
//		int temp = 0;
//
//		for (int i = 0; i < num; i++)
//		{
//			scanf("%d", &temp);
//
//			if (temp < 0)
//			{
//				count++;
//			}
//
//			if (temp > 0)
//			{
//				k++;
//				sum += temp;
//			}
//
//		}
//		printf("%d %.1f\n", count, sum / k);
//
//	}
//	return 0;
//}

//int main()
//{
//	int m, n;
//	printf("Enter m, n;");
//	scanf("%d%d", &m, &n);
//	while (m != n)
//	{
//		while (m > n) m = m - n;
//		while (n > m) n = n - m;
//	}
//	printf("m=%d\n", m);
//	return 0;
//}

//int main()
//{
//	char c;
//	int v0 = 0,v1 = 0, v2 = 0;
//	do {
//		switch (c = getchar())
//		{
//		case 'a':case'A' :
//		case 'e':case'E' :
//		case 'i':case'I' :
//		case 'o':case'O' :
//		case 'u':case'U' : v1 += 1;
//		default:v0 += 1; v2 += 1;
//		}
//	} while (c != '\n');
//	printf("v0=%d,v1=%d,v2=%d", v0, v1, v2);
//	return 0;
//}

//int main()
//{
//	int a[] = { 4,0,2,3,1 }, i, j, t;//?
//		for (i = 1; i < 5; i++)
//		{
//			t = a[i];
//			j = i - 1;
//			while (j >= 0 && t < a[j])
//			{
//				a[j + 1] = a[j];
//				--j;
//			}
//			a[j + 1] = t;
//	}
//		printf("%d", a);
//
//	return  0;
//}

//int main()
//{
//	int num = 0;
//	while (~scanf("%d", &num))
//	{
//		for (int i = 0; i < num; i++)
//		{
//			char arr[101] = { 0 };
//			scanf("%s", arr);
//			int lower = 0, higher = 0, digit = 0, other = 0;
//			if (arr[0] > '0' && arr[0] < '9')
//			{
//				printf("NO\n");
//				continue;
//			}
//			if (strlen(arr) < 8)
//			{
//				printf("NO\n");
//				continue;
//			}
//
//			for (int i = 0; arr[i] != '\0'; i++)
//			{
//				if (arr[i] > '0' && arr[i] < '9') {
//					lower++;
//				}
//				else if (arr[i] > 'a' && arr[i] < 'z') {
//					higher++;
//				}
//				else if (arr[i] > 'A' && arr[i] < 'Z') {
//					digit++;
//				}
//				else
//				{
//					other++;
//				}
//				
//			}
//
//			if (other != 0)
//			{
//				printf("NO\n");
//				continue;
//			}
//			if (((lower > 0) + (higher > 0) + (digit > 0)) < 2)
//			{
//				printf("NO\n");
//				continue;
//			}
//			printf("YES\n");
//
//		}
//
//	}
//	return 0;
//}

//#include<stdio.h>
//#include<string.h>
//int main()
//{
//    int n = 0;
//    while (~scanf("%d", &n))
//    {
//        for (int i = 0; i < n; i++)
//        {
//            char pwd[101] = { 0 };
//            scanf("%s", pwd);
//            int lower = 0, higher = 0, digit = 0, other = 0;
//            if (pwd[0] >= '0' && pwd[0] <= '9')
//            {
//                printf("NO\n");
//                continue;
//            }
//            if (strlen(pwd) < 8)
//            {
//                printf("NO\n");
//                continue;
//            }
//            for (int i = 0; pwd[i] != '\0'; i++)
//            {
//                if (pwd[i] >= '0' && pwd[i] <= '9') {
//                    digit++;
//                }
//                   
//                else if (pwd[i] >= 'a' && pwd[i] <= 'z') {
//                    lower++;
//                }
//                   
//                else if (pwd[i] >= 'A' && pwd[i] <= 'Z') {
//                    higher++;
//                }
//                else {
//                    other++;
//                } 
//            }
//            if (other != 0)
//            {
//                printf("NO\n");
//                continue;
//            }
//            if ((lower > 0) + (higher > 0) + (digit > 0) < 2)
//            {
//                printf("NO\n");
//                continue;
//            }
//            printf("YES\n");
//        }
//    }
//    return 0;
//}

//int main()
//{
//	int n = 0;
//	while (~scanf("%d", &n)
//	{
//		for (int i = 0; i <n; i++)
//		{
//			char arr[101] = { 0 }£»
//			scanf("%s", arr);
//			int lower = 0, higher = 0, digit = 0, other = 0;
//
//			if (arr[0] > '0' && &< arr[o] < '9')
//			{
//				printf("NO\n");
//				continue;
//			}
//
//			if (strlen(arr) < 8)
//			{
//				printf("NO\n");
//				continue;
//			}
//
//			for (int i = 0; arr[i] != '\0'; i++)
//			{
//				if (arr[i] > '0' && arr[i] < '9')
//					lower++;
//				else if (arr[i] > 'a' && arr[i] < 'z')
//					higher++;
//				else if (arr[i] > 'A' && arr[i] < 'Z')
//					digit++;
//				else
//					other++;
//			}
//
//			if (other != 0)
//			{
//				printf("NO\n");
//				continue;
//			}
//			if ((lower > 0) + (higher>0) + (digit>0) < 2) 
//			{
//				printf("NO\n");
//				continue;
//			}
//			printf("YES\n");
//		}
//
//	}
//	return 0;
//}

//int main()
//{
//	char ch[80]="123abcdEFG*&";
//	int j;
//	puts(ch);
//	for (j = 0; ch[j] != '\0'; j++)
//		if (ch[j] >= 'A' && ch[j] <= 'Z')
//			ch[j] = ch[j] + 'e' - "E";
//	puts(ch);
//	return 0;
//}

//int main()
//{
//
//
//	while (printf("*")) {
//		printf("ÄãÊÇÖí")£»
//	}
//	return 0;
//}

//int main()
//{
//	char ch;
//	while ((ch = getchar())!='\n')
//	{
//		if(ch % 2 != 0 && (ch >= 'a' && ch <= 'z'))
//			ch = ch - 'a' + 'A';
//		putchar(ch);
//	}
//	printf("\n");
//
//
//	return 0;
//}

int main()
{

	for (int i = 0; i || i++ < 5;)
	{
		printf("*");
	}
	
	return 0;
}