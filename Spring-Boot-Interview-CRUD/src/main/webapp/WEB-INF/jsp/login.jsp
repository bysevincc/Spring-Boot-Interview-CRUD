<html>
<head>

    
    
    
    <style>
    
    
    body{
    margin: 0;
    padding: 0;
    background-color: hsla(50, 33%, 25%, .75);
    background-size: cover;
    background-position: center;
    font-family: sans-serif;
}
.login-box{
    width: 320px;
    height: 420px;
    background: rgba(0, 0, 0, 0.5);
    color: #fff;
    top: 50%;
    left: 50%;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 70px 30px;
}
.avatar{
    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: absolute;
    top: -50px;
    left: calc(50% - 50px);
}
h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
}
.login-box p{
    margin: 0;
    padding: 0;
    font-weight: bold;
}
.login-box input{
    width: 100%;
    margin-bottom: 20px;
}
.login-box input[type="text"], input[type="password"]
{
    border: none;
    border-bottom: 1px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
.login-box input[type="submit"]
{
    border: none;
    outline: none;
    height: 40px;
    background: #1c8adb;
    color: #fff;
    font-size: 18px;
    border-radius: 20px;
}
.login-box input[type="submit"]:hover
{
    cursor: pointer;
    background: #39dc79;
    color: #000;
}

.login-box a{
    text-decoration: none;
    font-size: 14px;
    color: #fff;
}
.login-box a:hover
{
    color: #39dc79;
}


    
    </style>
    

 
 
</head>
    <body>

    <div class="login-box">
   <form method="post">
        <h1>Giris Sayfasi</h1>
          <font color="red">${errorMessage}</font>
          <label for="uname"><b>Kullanici ismi</b></label>
             <input type="text" name="name" placeholder="Isim giriniz" required />
		  
		
             <label for="psw"><b>Sifre</b></label>
            <input type="password" name="password"  placeholder="Sifre Giriniz" required /> 
		 
            <input type="submit" >
            </form>
        
        
        </div>
    
    </body>
</html>