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

.login-container {
  width: 100%;
  max-width: 400px;
  padding: 30px;
  box-sizing: border-box;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

.login-form {
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
  justify-content: space-between;
  align-items: center;
  font-size: 14px;
  color: #555;
}

.forgot-password,
.signup-link {
  color: #007bff;
  text-decoration: none;
  transition: color 0.3s ease;
}

.forgot-password:hover,
.signup-link:hover {
  color: #0056b3;
}

</style>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${title}</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="login-container">
    <form method="POST" action="${classpath}/login_processing_url" class="login-form">
      <h1>Đăng nhập</h1>
      <div class="form-group">
        <input type="text" id="username" name="username" placeholder="username" required>
      </div>
      <div class="form-group">
        <input type="password" id="password" name="password" placeholder="password" required>
      </div>
      <button type="submit">Đăng nhập</button>
      <div class="bottom-text">
        <a href="#" class="forgot-password">Quên mật khẩu?</a>
        <span>|</span>
        <a href="${classpath }/signup" class="signup-link">Đăng ký</a>
      </div>
    </form>
  </div>
</body>
</html>

    
    