insert into book values(11,"The Pragmatic Programmer");
insert into member values(43, "Oscar Garcia");
insert into checkout_item default values;
update checkout_item
set member_id = 43, book_id = 11
where member_id is null;   
select member.name from member 
where member.id in (
    select checkout_item.member_id
    from book, checkout_item
    where checkout_item.book_id = book.id
    and book.title = 'The Pragmatic Programmer'
);