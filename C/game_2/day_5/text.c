#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include"game.h"
void menu()
{
	printf("***��ӭ����ɨ����ҫ***\n");
	printf("****1.play 0.exit****\n");
	printf("*********************\n");
}

 void game()
{
	char mine[ROWS][COLS] = { 0 };//����
	char show[ROWS][COLS] = { 0 };//ɨ��
	//��ʼ������
	InitBoard(mine,ROWS, COLS,'0');
	InitBoard(show, ROWS, COLS, '*');
	//��ӡ����
	
	
	/*DispalyBoard(show, ROW, COL);*/
	//������
	SetMine(mine ,ROW ,COL);
	/*DispalyBoard(mine, ROW, COL);*/
	/*DispalyBoard(mine, ROW, COL);*/
	//ɨ��
	DispalyBoard(show, ROW, COL);
	FindMine(mine, show, ROW, COL);
}

void text() {
	int input = 0;
	srand((unsigned int)time(NULL));
	do {
		menu();
		printf("���������ѡ��>");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			//printf("ɨ��\n");
			break;
		case 0:
			printf("�˳���Ϸ��");
			break;
		default:
			printf("��������������������룡");
			break;
		}
	} while (input);

}

int main() {

	text();
	return 0;
}