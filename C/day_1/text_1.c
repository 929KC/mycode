#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include "game.h"
//������������Ϸ
//��Ϸ�˵�
void menu() 
{
	printf("****************************\n");
	printf("****1. ������ 0. �˳���Ϸ***\n");
	printf("****************************\n");
}
//��Ϸ���㷨ʵ��
void game() {
	char ret = 0;
	//��������-�������Ϣ
	char board[ROW][COL] = {0};//��������Ϊ�ո�
	//��ʽ������
	InitBoard(board,ROW,COL);
	//��ӡ����
	DisplayBoard(board, ROW, COL);

	while(1)
	{
		//�������
		PlayerMove(board, ROW, COL);
		DisplayBoard(board, ROW, COL);
		//�ж�����Ƿ�Ӯ
		ret=IsWin(board,ROW,COL);
		if (ret != 'C')
		{
			break;
		}
		//��������
		ComputerMove(board, ROW, COL);
		DisplayBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}

	}
	if (ret == '*')
	{
		printf("���Ӯ��\n");
	}
	else if (ret == '#')
	{
		printf("����Ӯ��\n");
		}
	else
	{
		printf("ƽ�֣�\n");
	}
}
void text() 
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do 
	{
		menu();
		printf("���������ѡ��:");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ");
			break;
		default:
			printf("��������������������룡\n");
		}

	} while (input);

}
int main()
{
	text();
	return 0;
}