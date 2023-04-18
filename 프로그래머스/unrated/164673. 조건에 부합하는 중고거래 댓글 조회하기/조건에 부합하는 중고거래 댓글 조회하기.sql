-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, Date_format(r.created_date,'%Y-%m-%d') CREATED_DATE
from used_goods_board b join used_goods_reply r
on b.board_id = r.board_id
where Date_format(b.created_date, '%Y-%m') = '2022-10'
order by r.created_date, b.title;