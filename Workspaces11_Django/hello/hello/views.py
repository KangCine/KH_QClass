from django.http import HttpResponse


def index(request):
    return HttpResponse('''<h1>hello, world!</h1>
    <a href="/hello01">hello01</a><br/>
    <a href="/hello02">hello02</a>
    ''')