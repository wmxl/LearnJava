--查询2018/5/30日当天发表过博客的用户名称
select distinct name from user join blog
on blog.user_id = user.id
where blog.add_time BETWEEN '2021-2-8 00:00:00' and '2021-2-8 23:59:59'

--查询2018年5月份发表博客数量最多（超过一篇博客的）的10人
select user_id, count(blog.id) as cnt from user join blog
on blog.user_id = user.id
where add_time between '2018-5-1 00:00:00' and '2018-5-31 23:59:59'
group by user.id having cnt > 1
order by cnt desc
LIMIT 0,10