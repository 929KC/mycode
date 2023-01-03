#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include "game.h"
//测试三子棋游戏
//游戏菜单
void menu() 
{
	printf("****************************\n");
	printf("****1. 三子棋 0. 退出游戏***\n");
	printf("****************************\n");
}
//游戏的算法实现
void game() {
	char ret = 0;
	//定义数组-存放数信息
	char board[ROW][COL] = {0};//数组内容为空格
	//格式化棋盘
	InitBoard(board,ROW,COL);
	//打印键盘
	DisplayBoard(board, ROW, COL);

	while(1)
	{
		//玩家下棋
		PlayerMove(board, ROW, COL);
		DisplayBoard(board, ROW, COL);
		//判断玩家是否赢
		ret=IsWin(board,ROW,COL);
		if (ret != 'C')
		{
			break;
		}
		//电脑下棋
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
		printf("玩家赢！\n");
	}
	else if (ret == '#')
	{
		printf("电脑赢！\n");
		}
	else
	{
		printf("平局！\n");
	}
}
void text() 
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do 
	{
		menu();
		printf("请输入你的选择:");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏");
			break;
		default:
			printf("你输入的有误，请重新输入！\n");
		}

	} while (input);

}
int main()
{
	text();
	return 0;
}