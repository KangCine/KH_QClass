from bs4 import BeautifulSoup
import requests
import json

resp= requests.get('https://www.iei.or.kr/intro/teacher.kh')

soup =BeautifulSoup(resp.text,'html.parser')

khs = soup.find('div',{'class': 'content_sub_wrap_box'})

li= khs.select('li')

lst =list()

for chd in li:
    name = chd.find('p',class_= 'intro_name').text
    imgs = chd.find('img')['src']
  
    
    tmp = {}
    tmp['name'] = name
    tmp['imgs'] = imgs
    lst.append(tmp)
    
res= {}
res['kh']= lst


res_json = json.dumps(res,ensure_ascii=False)
print(res_json)

with open('khs.json','w',encoding ='utf-8')as f:    
    f.write(res_json)
