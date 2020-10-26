<%@page import="dto.note.NoteReceiverView"%> <%@page import="java.util.List"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%
List<NoteReceiverView>
  manUser = (List<NoteReceiverView
    >) request.getAttribute("manUser"); %> <% List<NoteReceiverView>
      accUser = (List<NoteReceiverView
        >) request.getAttribute("accUser"); %> <% List<NoteReceiverView>
          hrUser = (List<NoteReceiverView
            >) request.getAttribute("hrUser"); %> <% List<NoteReceiverView>
              devUser = (List<NoteReceiverView
                >) request.getAttribute("devUser"); %> <% List<NoteReceiverView>
                  salesUser = (List<NoteReceiverView
                    >) request.getAttribute("salesUser"); %>

                    <!DOCTYPE html>
                    <html>
                      <head>
                        <meta charset="UTF-8" />
                        <title>Insert title here</title>

                        <script
                          type="text/javascript"
                          src="https://code.jquery.com/jquery-2.2.4.min.js"
                        ></script>
                        <script type="text/javascript">
                          $(document).ready(function () {
                            $('.none').css('display', 'none');

                            $('#dept').change(function () {
                              $('.none').css('display', 'none');
                              var dept = document.getElementById('dept');
                              var selected = dept.options[dept.selectedIndex].value;
                              /* console.log(selected)*/
                              /* alert(selected)  */

                              if (selected == 'man') {
                                $('#selectMan').toggle();
                                if ($('#selectMan').hasClass('none')) {
                                  $('#selectMan').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectMan').addClass('view');
                                } else {
                                  $('#selectMan').addClass('none');
                                  $('#selectMan').removeClass('view');
                                }
                              } else if (selected == 'hr') {
                                $('#selectHr').toggle();
                                if ($('#selectHr').hasClass('none')) {
                                  $('#selectHr').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectHr').addClass('view');
                                } else {
                                  $('#selectHr').addClass('none');
                                  $('#selectHr').removeClass('view');
                                }
                              } else if (selected == 'acc') {
                                $('#selectAcc').toggle();
                                if ($('#selectAcc').hasClass('none')) {
                                  $('#selectAcc').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectAcc').addClass('view');
                                } else {
                                  $('#selectAcc').addClass('none');
                                  $('#selectAcc').removeClass('view');
                                }
                              } else if (selected == 'sal') {
                                $('#selectSal').toggle();
                                if ($('#selectSal').hasClass('none')) {
                                  $('#selectSal').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectSal').addClass('view');
                                } else {
                                  $('#selectSal').addClass('none');
                                  $('#selectSal').removeClass('view');
                                }
                              } else if (selected == 'addr') {
                                $('#selectAddr').toggle();
                                if ($('#selectAddr').hasClass('none')) {
                                  $('#selectAddr').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectAddr').addClass('view');
                                } else {
                                  $('#selectAddr').addClass('none');
                                  $('#selectAddr').removeClass('view');
                                }
                              } else if (selected == 'dev') {
                                $('#selectDev').toggle();
                                if ($('#selectDev').hasClass('none')) {
                                  $('#selectDev').removeClass('none');
                                  $('#dept ~ select').removeClass('view');
                                  $('#dept ~ select').addClass('none');
                                  $('#selectDev').addClass('view');
                                } else {
                                  $('#selectDev').addClass('none');
                                  $('#selectDev').removeClass('view');
                                }
                              }
                            });

                            let cnt = 0;
                            $('#add').click(function () {
                              console.log('clicked');
                              console.log($('.view > option:selected').val());
                              console.log($('.view > option:selected').val());
                              var user_no = $('.view > option:selected').val();
                              console.log(user_no);

                              $('#receiver').append(
                                '<input type ="text" readonly="readonly" width="30px;" name="receiver' +
                                  cnt +
                                  '" value="' +
                                  $('.view > option:selected').val() +
                                  '">'
                              );
                              cnt++;
                            });
                          });
                        </script>

                        <style type="text/css">
                          textarea {
                            resize: none;
                          }
                          span {
                            background-color: antiquewhite;
                            margin: 5px;
                            padding: 0px 5px;
                          }
                          #receiver > input {
                            width: 23px;
                          }
                        </style>
                      </head>
                      <body>
                        <h1>쪽지 보내기</h1>
                        <hr />

                        <form action="/note/send" method="POST">
                          <table>
                            <tbody>
                              <tr>
                                <td><label for="title">제목</label></td>
                                <td><input type="text" name="title" id="title" /></td>
                              </tr>
                              <tr>
                                <td>받는사람</td>
                                <td id="receiver"></td>
                                <td></td>
                              </tr>
                              <tr>
                                <td>받는사람추가</td>
                                <td id="select">
                                  <select name="dept" id="dept">
                                    <option value="select">부서선택</option>
                                    <option id="acc" value="acc">회계</option>
                                    <option id="man" value="man">경영</option>
                                    <option id="hr" value="hr">인사</option>
                                    <option id="dev" value="dev">개발</option>
                                    <option id="sal" value="sal">영업</option>
                                    <option id="addr" value="addr">내주소록</option>
                                  </select>
                                  <select name="man" id="selectMan" class="none selectPerson">
                                    <% for(int i = 0; i < manUser.size(); i++){ %>
                                    <option value="<%= manUser.get(i).getUser_no() %>">
                                      <%= "사번("+ manUser.get(i).getUser_no() + ")" + " / " +
                                      manUser.get(i).getUser_name() %>
                                    </option>
                                    <%} %>
                                  </select>
                                  <select name="acc" id="selectAcc" class="none selectPerson">
                                    <% for(int i = 0; i < accUser.size(); i++){ %>
                                    <option value="<%= accUser.get(i).getUser_no() %>">
                                      <%= "사번("+ accUser.get(i).getUser_no() + ")" + " / " +
                                      accUser.get(i).getUser_name() %>
                                    </option>
                                    <%} %>
                                  </select>
                                  <select name="hr" id="selectHr" class="none selectPerson">
                                    <% for(int i = 0; i < hrUser.size()-1; i++){ %>
                                    <option value="<%= hrUser.get(i).getUser_no() %>">
                                      <%= "사번("+ hrUser.get(i).getUser_no() + ")" + " / " +
                                      hrUser.get(i).getUser_name() %>
                                    </option>
                                    <%} %>
                                  </select>
                                  <select name="dev" id="selectDev" class="none selectPerson">
                                    <% for(int i = 0; i < devUser.size(); i++){ %>
                                    <option value="<%= devUser.get(i).getUser_no() %>">
                                      <%= "사번("+ devUser.get(i).getUser_no() + ")" + " / " +
                                      devUser.get(i).getUser_name() %>
                                    </option>
                                    <%} %>
                                  </select>
                                  <select name="sal" id="selectSal" class="none selectPerson">
                                    <% for(int i = 0; i < salesUser.size(); i++){ %>
                                    <option value="<%= salesUser.get(i).getUser_no() %>">
                                      <%= "사번("+ salesUser.get(i).getUser_no() + ")" + " / " +
                                      salesUser.get(i).getUser_name() %>
                                    </option>
                                    <%} %>
                                  </select>
                                  <select name="addr" id="selectDevAddr" class="none selectPerson">
                                    <option value=""></option>
                                  </select>
                                </td>
                                <td><button type="button" id="add">추가</button></td>
                              </tr>

                              <tr>
                                <td>쪽지내용</td>
                                <td>
                                  <textarea
                                    name="article"
                                    id="article"
                                    cols="30"
                                    rows="10"
                                  ></textarea>
                                </td>
                              </tr>
                              <tr>
                                <td></td>
                                <td><input type="submit" value="보내기" /></td>
                              </tr>
                            </tbody>
                          </table>
                        </form>
                      </body>
                    </html> </NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView></NoteReceiverView
></NoteReceiverView>
