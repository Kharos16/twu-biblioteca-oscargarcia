select member.name from member 
where member.id in (
    select checkout_item.member_id
    from book, checkout_item
    where checkout_item.book_id = book.id
    and book.title = 'The Hobbit'
);