#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<string.h>
//int main() {
//	//����ֵ���������ȷƥ��Ĳ�������
//	//����scanf("%d %d",&a,&b)    ��a��b����ȷ�õ�ֵ���򷵻�2
//	//��a�õ�ֵ��b���õ�ֵ���򷵻�1�����سɹ����յ���ֵ�ĸ�����
//		//����������������end of file������ֵΪEOF(-1)
//	int iq = 0;
//	while (scanf("%d", &iq) != EOF) {
//		if (iq >= 14) {
//			printf("Genius\n");
//		}
//	}
//	return 0;
//}
//int main() {
//	char arr[] = { 'a','b','c','\0'};
//	printf("%d\n", strlen(arr));
//	return 0;
//}
// ��Ŀ������
//int main() {
//	//C�����У�0��ʾ�٣���0��ʾ��
//	int flag = 5;
//	if (!flag) {
//		printf("hehehehe\n");
//	}
//	return 0;
//}
//int main() {
//	int a = -10;
//	int b = +a;
//	printf("%d\n", b);
//
//	return 0;
//}
//sizeof��ʹ��
//int main() {
//	int a = 10;
//	printf("%d\n", sizeof(a));
//	printf("%d\n", sizeof(int));
//	//�����������������ռ�ռ�Ĵ�С
//	return 0;
//}
//int main() {
//	int a = 10;
//	/*int b = a + 1;*/
//	int b = a++;//ǰ��++����++����ʹ��//a=a+1;b=a;
//	int b = ++a;//����+=����ʹ�ã���++//int b=a;a=a+1;
//	int b = --a;*///a=a-1;b=a;
//	int b = a--;//b=a; a=a-1;
//
//	printf("a=%d b=%d\n", a, b);
//	return 0;
//}
//int main() {
//	//��һ
//	int a = 3;
//	int b = 5;
//	int m = 0;
//	if (a > b) {
//		m = a;
//	}
//	else {
//		m = b;
//	}
//	printf("%d\n", m);
//	//����
//	m = a > b ? a : b;
//	printf("%d\n", m);
//	return 0;
//}
//int main() {
//	int a = 3;
//	int b = 20;
//	int c = 0;
//	int d = (a -= 3,b+=a,c=a-b,b=a-4);
//	printf("%d\n",d);
//	return 0;
//}
//int main() {
//	int arr[10] = { 0 };
//	arr[5] = 9;//[]�±����ò����������Ĳ����������������±ꡣ
//
//	return 0;
//}
// 
//int get_max(int x,int y) {
//	return x > y ? x : y;
//}
//int main() {
//	int m = get_max(3, 5); //�����ĵ��ò����������Ĳ������ǣ���������3,5
//	printf("%d", m);
//	return 0;
//}
//void text() {
//static	int a = 5;
// static���εľֲ�����ʱ�򣬾ֲ������ͱ���˾�̬�ľֲ�����
// ���˾ֲ���Χ���������٣���һ�ν��뺯����Ȼ����
// ��ʵ����Ϊ��static���εľֲ������Ǵ洢�ھ�̬����
// static���ξֲ������ǣ�ʵ�ʸı���Ǳ����Ĵ洢λ�ã�����һ���ֲ������Ƿ���ջ���ģ���static
// ���κ���ھ�̬�����Ӷ����£�������������Ȼ���ڣ��������ڲ�û�н���
//	a++;
//	printf("%d " , a);
//}
//int main() {
//	int i = 0;
//	while (i < 10) {
//		text();
//		i++;
//	}
//	return 0;
//}