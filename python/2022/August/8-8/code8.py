#实现文件查找工具
import  os

inputpath = input("请输入搜索路径:")
pattern = input("请输入关键词:")

for dirpath,dirnames,filenames in os.walk(inputpath):
    for f in filenames:
        if pattern in f:
            print(f'{dirpath}/{pattern}')