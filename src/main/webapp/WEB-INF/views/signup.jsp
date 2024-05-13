<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

   
<!DOCTYPE html>
<html lang="en">

<style>
    body {
  font-family: 'Roboto', sans-serif;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f0f0f0;
}

.register-container {
  width: 100%;
  max-width: 400px;
  padding: 30px;
  box-sizing: border-box;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

.register-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

input {
  padding: 12px;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 16px;
}

button {
  padding: 12px;
  border: none;
  border-radius: 6px;
  background-color: #007bff;
  color: #fff;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #0056b3;
}

.bottom-text {
  margin-top: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 14px;
  color: #555;
}

.login-link {
  margin-left: 5px;
  color: #007bff;
  text-decoration: none;
  transition: color 0.3s ease;
}

.login-link:hover {
  color: #0056b3;
}

</style>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${classpath}</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="register-container">
    <form action="${classpath}/register" method="post" class="register-form">
      <h1>Đăng ký</h1>
      <div class="form-group">
        <input type="text" id="username" name="username" placeholder="username" required>
      </div>
      <div class="form-group">
        <input type="password" id="password" name="password" placeholder="password" required>
      </div>
      <button type="submit">Đăng ký</button>
      <div class="bottom-text">
        <span>Bạn đã có tài khoản?</span>
        <a href="${classpath }/login" class="login-link">Đăng nhập</a>
      </div>
    </form>
  </div>
</body>
</html>
   