#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"

void InitBoard(char board[ROWS][COLS], int  rows, int  cols, char ret)
{
	int i = 0, j = 0;
	for (i = 0; i < rows; i++) 
	{
		for (j = 0; j < cols; j++)
		{
			board[i][j] = ret;
		}

	}
		
}

void DispalyBoard(char board[ROWS][COLS], int row, int col)
{
	int i = 0, j = 0;
	for (i = 0;i<=row;i++)
	{
		printf("%d ", i);//��ӡ�к�
	}
	printf("\n");
	for (i = 1; i <= row; i++)
	{	
		//��ӡ�к�
		printf("%d ", i);
		for (j = 1;j <= col; j++)
		{
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
}

void SetMine(char board[ROWS][COLS], int row, int col)
{
	int count = EASY_COUNT;
	while (count)
	{
		int x = rand() % row + 1;//ģrow x>=0&&x<8 ����+1 --> x>=1&&x<=9
		int y = rand() % col + 1;//ģcol x>=0&&x<8 ����+1 --> x>=1&&x<=9
		if(board[x][y]=='0')
		{
			board[x][y] = '1';
			count--;
		}
		
	}
}


int get_mine_count(char mine[ROWS][COLS],int x,int y)
{
	return mine[x - 1][y] + mine[x - 1][y - 1]
	+ mine[x][y - 1] + mine[x + 1][y - 1] 
	+ mine[x + 1][y + 1] + mine[x][y + 1] 
	+ mine[x - 1][y + 1] - 8 * '0';
}

void FindMine(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col)
{
	int win = 0;
	int x = 0, y = 0;
	while (win< row * col - EASY_COUNT)
	{
		printf("�������Ų�����꣺>");
		scanf("%d %d",&x, &y);
		if (x >= 1 && x <= row && y >= 1 && y <= col)
		{
			if (mine[x][y] == '1')
			{
				printf("���ź����㱻ը���ˣ�\n");
				DispalyBoard(mine, ROW, COL);
				break;
			}
			else
			{
				int count = get_mine_count(mine, x, y);
				show[x][y] = count + '0';
				DispalyBoard(show, ROW, COL);
				win++;
			}
		}
		else
		{
			printf("���������Ƿ������������룡\n");
		}
		if (win == row * col - EASY_COUNT)
		{
			printf("��ϲ�����׳ɹ���\n");
		}
	}


}