#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include "contact.h"
void menu()
{
	printf("**|******************|**\n");
	printf("**|1.Add  2.Delete***|**\n");
	printf("**|3.Seacher 4.Modify|**\n");
	printf("**   |5.Show 6.Sort|  **\n");
	printf("**      |0.Exit|      **\n");
	printf("**********|***|*********\n");
	printf("************|***********\n");
}

void text()
{
	int input = 0;
	contact con;
	InitContact(&con);
	do {
		menu();
		printf("����������ѡ��");
		scanf("%d", &input);
		switch (input)
		{
		case ADD:
			AddContact(&con);
			break;
		case DELETE:
			DeleteContact(&con);
			break;
		case SEARCH:
			SearchContact(&con);
			break;
		case MODIFY:
			ModifyContact(&con);
			break;
		case SHOW:
			ShowContact(&con);		
			break;
		case SORT:
			SortContact(&con);
			break;
		case EXIT:
			printf("�˳�ͨѶ¼");
			break;
		default:
			printf("����ѡ���������������룡");
		}
	} while (input);

}

int main() 
{
	text();
	return 0;
}