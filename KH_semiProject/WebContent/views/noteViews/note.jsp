<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>쪽지 보내기</h1>
    <hr />

    <form action="/note/create" method="POST">
      <table>
        <tbody>
          <tr>
            <td>부서 선택</td>
            <td>
              <select name="" id="">
                <option value=""><%= %></option>
              </select>
            </td>
          </tr>
          <tr>
            <td><label for="title">제목</label></td>
            <td><input type="text" name="title" id="title" /></td>
          </tr>
        </tbody>
      </table>
    </form>
  </body>
</html>
