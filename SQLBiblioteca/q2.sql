select
(select count(1) from member)
-
(select count() from checkout_item);