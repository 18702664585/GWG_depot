#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# @author hjbj
# @date 2021/8/9
# @file wyy_test.py
import requests
from lxml import etree
import os
folder_or_dir = r'f:/网易云热门歌曲'
if not os.path.exists(folder_or_dir):
	print("文件夹已创建 !!!!!!")
	os.makedirs(folder_or_dir)
url = 'https://music.163.com//discover/toplist?id=3778678'
response = requests.get(url=url)
html = etree.HTML(response.text)
lyric_name = html.xpath('//ul[@class="f-hide"]/li/a/text()')
lyric_id = html.xpath('//ul[@class="f-hide"]/li/a/@href')
song_name = []
song_id = []
for a,b in zip(lyric_name,lyric_id):
    song_name.append(a)
    song_id.append(b[9:])
def download_song(name,id):
    for a,b in zip(name,id):
        url_last = url_base + str(b)
        headers  ={
            "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36",
        }
        response = requests.get(url=url_last, headers=headers)

        with open('F:/网易云热门歌曲/%s.mp3'%a,'wb',) as file:
            file.write(response.content)
        print('《' + a +'》' + '已下载完成')
if __name__ == '__main__':
    url_base = 'https://music.163.com/song/media/outer/url?id='
    download_song(name=song_name,id=song_id)