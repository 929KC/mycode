#define _CRT_SECURE_NO_WARNINGS 1
#include "game.h"

void InitBoard(char board[ROW][COL], int  row, int col)
{
	for (int i = 0; i < ROW; i++)
	{
		for (int j = 0; j < COL; j++)
		{
			board[i][j] = ' ';//��ʼ��Ϊ�ո�
		}
	}

}

//1.0�汾
//void DisplayBoard(int board[ROW][COL], int  row, int  col)
//{
//	for (int i = 0; i < row; i++)
//	{
//		//1.��ӡ һ�е�����
//		printf(" %c | %c | %c \n", board[i][0], board[i][1], board[i][2]);
//		//2.��ӡ�ָ���
//		printf("---|---|---\n");
//	}
//
//}

void DisplayBoard(char board[ROW][COL], int  row, int  col)
{
	int i;
	for ( i = 0; i < row; i++)
	{
		int j;
		for ( j = 0; j < col; j++)
		{
			//1.��ӡ һ�е�����
			printf(" %c ", board[i][j]);
			if (j < col - 1)
			{
				printf("|");
			}
		}
		printf("\n");
		//2.��ӡ�ָ���
		if (i < row - 1) {
			for (j = 0; j < col; j++)
			{
				printf("---");
				if (j < col - 1)
				{
					printf("|");
				}
		}
			printf("\n");
		}
	 }

}

void PlayerMove(char board[ROW][COL], int row, int col)
{
	int x = 0 , y = 0;
	printf("����ߣ�>\n");
	while (1)
	{
		printf("������Ҫ�µ����꣺>");
		scanf("%d%d",&x,&y);
		//�ж�����ĺϷ���
		if (x >= 1 && x <=  row && y >= 1 && y <= col)
		{
			if (board[x - 1][y - 1] == ' ')
			{
				board[x - 1][y - 1] = '*';
				break;
			}
			else
			{
				printf("�����걻ռ�ã�\n");
			}
		}
		else
		{
			printf("����Ƿ������������룡\n");
		}
	}
}

void ComputerMove(char board[ROW][COL], int row, int col)
{
	int x=0, y = 0;
	printf("�����ߣ�>\n");
	while (1)
	{
		x = rand() % row;
		y = rand() % col;
		if (board[x][y] == ' ')
		{
			board[x][y] = '#';
			break;
		}
	}

}

int IsFull(char board[ROW][COL], int row, int col)
{
	int i = 0, j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')
			{
				return 0;//����δ��
			}
		}
	}
	return 1;//��������
}

char IsWin(char board[ROW][COL], int row, int col)
{
	int i = 0;
	//������
	for (i = 0; i < row; i++)
	{
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != ' ')
		{
			return board[i][1];
		}
	}
	//������
	for (i = 0; i < col; i++)
	{
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[1][i] != ' ')
		{
			return board[1][i];
		}
	}
	//�����Խ���
	if (board[0][0] == board[1][1]&&board[1][1]==board[2][2]&&board[1][1]!=' ')
	{
		return board[1][1];
	}
	if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != ' ')
	{
		return board[1][1];
	}
	//�ж��Ƿ�ƽ��
	if (1 == IsFull(board, ROW, COL))
	{
		return 'Q';
	}
	return 'C';
}