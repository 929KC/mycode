#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
 /*static  int g_reen = 2021;*/
 // int Add(int x, int y) {
	//return  x+y;
//} 
//int get_max(int x, int y, int  z) {
//	int Max = x;
//	if (y > Max) {
//		Max = y;
//	} else if (z > Max) {
//		Max = z;
//		}
//	return Max;
//}
//int main() {
//	int a = 0, b = 0, c = 0;
//	scanf("%d %d %d", &a,&b,&c);
//	double d = get_max(a + b, b, c) / ((get_max(a, b + c, c)) + get_max(a, b, b + c));
//	printf("%.2f", d);
//		return 0;
//}
//int main() {
//	int x = 0;
//	if ((x != 0) && (x++ > 10)) {
//	printf("Hello World");
//	}
//	printf("%d", x);//x=0
//	return 0;
//
//}
//int main() {
//	int x = 0;
//	if ((x != 0) & (x++ > 10)) {
//		
//	}
//	printf("%d", x);//x=1
//	return 0;
//}
//int main() {
//	printf("%d", 1 & 3);
//	return 0;
//int get_max(int x, int y, int  z) {
//	int Max = x;
//	if (y > Max) {
//		Max = y;
//	}
//	else if (z > Max) {
//		Max = z;
//	}
//	return Max;
//}
//  int main() {
//	int a = 0, b = 0, c = 0;
//	double m = 0.0;
//	scanf("%d%d%d", &a,&b,&c);
//	int ret1 = get_max(a + b, b, c);
//	int ret2 = get_max(a, b + c, c);
//	int ret3 = get_max(a, b, b + c);
//	m = ret1*1.0 / (ret2 + ret3);
//	printf("%.2lf", m);
//	return 0;
//}
//int max3(int a, int b, int c)
//{
//    int max = a;
//    if (max < b)
//    {
//        max = b;
//    }
//    if (max < c)
//    {
//        max = c;
//    }
//    return max;
//}
//int main()
//{
//    int a = 0;
//    int b = 0;
//    int c = 0;
//    double sum = 0.0;
//    scanf("%d%d%d", &a, &b, &c);
//    int ret1 = max3(a + b, b, c);
//    int ret2 = max3(a, b + c, c);
//    int ret3 = max3(a, b, b + c);
//    sum = ret1 * 1.0 / (ret2 + ret3);
//    printf("%.2lf", sum);
//    return 0;
//}
//int max3(int x, int y, int z) {
//	int max = x;
//	if (y > max) {
//		max = y;
//	}
//	 if(z>max){
//		max = z;
//	}
//	return max;
//}
//int main() {
//	int a = 0, b = 0, c = 0;
//	double sum = 0.0;
//	scanf("%d%d%d", &a, &b, &c);
//	int ret1=max3(a + b, b, c);
//	int ret2=max3(a, b + c, c);
//	int ret3=max3(a, b, b + c);
//	 sum = ret1 * 1.0 / (ret2 + ret3);
//	printf("%.2lf", sum);
//	return 0;
//}
//int main() {
//	int i = 1;
//	float sum = 0.0;
//	float arr[5] = {0.0};
//	/*float number = 0;*/
//	while (i < 5) {
//		scanf("%f",&arr[i]);
//		sum += arr[i];
//			i++;
//	}
//	printf("%.2f\n", sum/5.0);
//	return 0;
//}
//int main() {
//	int T,k;
//	scanf("%d", &T);
//	scanf("%d", &k);
//	for (int i = 1; i <= T; i++) {
//		printf("*");
//		if (i == T) {
//			printf("\n");
//		}
//	}
//	for (int j = 1; j <= k; j++) {
//		printf("*");
//	}
//	return 0;
//}
//int main() {
//	int demo = 0;
//	while (scanf("%d", &demo) != EOF) {
//		for (int i = 1; i <= demo; i++) {
//			printf("*");
//		}
//		printf("\n");
//	}
//	
//	return 0;
//}
//int main() {
//    int times = 0;
//    while (scanf("%d", &times) != EOF) {
//        int i = 0;
//        //����ʹ����whileѭ������forѭ��
//        while (i < times) {
//            printf("*");
//            i++;
//        }
//        printf("\n");
//    }
//    return 0;
//}
//int main() {
//	int k;
//	int i;
//	double number = 0;
//	while(scanf("%d",&k)!= EOF) {
//		for ( i = 1; i <=k; i++) {
//			scanf("%.lf",&number);
//		}
//		if (i == k) {
//			printf("\n");
//		}
//	}
//	
//	return 0;
//}
//int main() {
//	double  arr[25] = { 0.0 };
//	int k=0;
//	for (int i = 0; i <= 24; i++) {
//		for (int j = 1; j <= 5; j++) {
//			scanf("%f", &arr[i]);
//		}
//		printf("\n");
//	}
//	for ( k = 0; k <= 24; k++) {
//		printf("%f", arr[k]);
//		if (k==4 || k == 9 || k == 14 || k = 19 || k == 24) {
//			printf("\n");
//		}
//	}
//
//
//}
//int main() {
//	double   score[5][6];
//	double sum[5] = { 0 };
//	for (int i = 0; i <5; i++) {
//		for (int k = 0; k < 5; k++) {
//			scanf("%lf ", &score[i][k]);
//			sum[i] +=score[i][k];
//		}
//	}
//	for (int j = 0; j <5; j++) {
//		for (int l = 0; l < 5; l++) {
//			printf("%.1f ", score[j][l]);
//		}
//		printf("%.1f \n", sum[j]);
//	}
//	return 0;
//}
//#define���峣���ͺ�
//#define MAX 1000//���峣��
//int main() {
//	int m = MAX;
//	printf("%d", m);
//	return 0;
//}
//#define MAX( x, y)((x)>(y)?(x):(y))
//int main() {
//	int a = 21, b = 90;;
//	int m = MAX(a, b);
//	printf("%d", m);
//	return 0;
//}
//ָ�����
//int main() {
//	char a = 'w';
//	//%p��ӡ��ַ
//	printf("%p\n", &a);
//
//	return 0;
//}
 //�ڴ浥Ԫ���б�ţ���ž��ǵ�ַ�����ǰѵ�ַ��Ϊ
//int main() {
//	int a = 10;
//	int* pa = &a;//pa��������ŵ�ַ�ģ��������ǰ�pa����ָ�����
//	*pa = 1000;//*�����ò�������������˼����ͨ��pa�д�ŵĵ�ַ���ҵ�paָ������ݡ�
//	printf("%d", a);
//
//	return 0;
//}
//ָ���С
//int main() {
//	int a = 10;
//	int* pa = &a;
//	printf("%d",sizeof(pa));
//	return 0;
//}
// �ṹ��
//struct stu {
//	char name[20];
//	int age;
//	char sex[3];
//	char id[20];
//};
//void print(struct stu* ps, struct stu* pd) {
//	/*printf("%s %d %s %s\n", (*ps).name, (*ps).age, (*ps).sex, (*ps).id);*/
//	//->�ṹ��Ա���ʲ�����
//	//J�ṹָ��->�ṹ���Ա
//	printf("%s %d %s %s\n",ps->name,ps->age,ps->sex,ps->id );
//	printf("%s %d %s %s\n", (*pd).name, (*pd).age, (*pd).sex, (*ps).id);
//}
//int main() {
//	//�ṹ�����
//	struct stu s1 = {"Ҷ�ﺭ",19,"Ů","202104040207"};
//	struct stu s2 = { "Ҷ����",19,"��","202104040208" };
//	//.�ṹ��Ա���ʲ�����
//	//�ṹ�����.�ṹ���Ա
//	//����ṹ������
//	scanf("%s %d %s %s\n",s1.name,&(s1.age),s1.sex,s1.id);
//		/*printf("%s %d %s %s\n", s1.name, s1.age, s1.sex, s1.id);
//		printf("%s %d %s %s", s2.name, s2.age, s2.sex, s2.id);*/
//		print(&s1, &s2);
//	return 0;


 /*static  int g_reen = 2021;*/
 // int Add(int x, int y) {
	//return  x+y;
//} 
//extern int a;
//int main() {
//
//	printf("%d", a);
//	return 0;
//}

//int main() {
//	/*char arr[] = { 'a','b','c' };
//	printf("%s\n", arr);
//	char arr2[] = { 'a','b','c','\0' };
//	printf("%s", arr2);*/
//	printf("c:\code\test.c\n");
//	return 0;
//}
//int main() {
//    char arr[] = { 'a','b','c' };
//    printf("%s\n", arr);
//    char arr2[] = { 'a','b','c','\0' };
//    printf("%s", arr2);
//    return 0;
//}
int main() {
	printf("c:\code\test.c\n");

	return 0;
}