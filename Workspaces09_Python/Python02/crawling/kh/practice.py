# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import json

resp = requests.get('https://www.iei.or.kr/intro/teacher.kh')

soup = BeautifulSoup(resp.text, 'html.parser')

pictures = soup.find('div', {'class': 'intro_list'})

li = pictures.select('li')

lst = list()

for chd in li:
    name = chd.find('p', {'class': 'intro_name'}).text
    img = chd.find('img')['src']

    tmp = {}
    tmp['name'] = name
    tmp['img'] = 'https://www.iei.or.kr'+img
    lst.append(tmp)

print(lst)


res = {}
res['kh'] = lst


res_json = json.dumps(res, ensure_ascii=False)


with open('kh.json', 'w', encoding='utf-8') as f:
    f.write(res_json)