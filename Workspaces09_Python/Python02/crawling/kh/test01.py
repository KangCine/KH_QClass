# -*- coding: utf-8 -*-

from bs4 import BeautifulSoup
import urllib.request


resp = urllib.request.urlopen("https://www.iei.or.kr/intro/teacher.kh")

soup = BeautifulSoup(resp,'html.parser')

khs = soup.find('div',{'class': 'content_sub_wrap_box'})

li= khs.select('li')

lst =list()

for chd in li:
   
    
    name =chd.find('p',class_='intro_name').text
  
    imgs =chd.find('img')['src']
    
    print('{}[{}]'.format(name, imgs))

