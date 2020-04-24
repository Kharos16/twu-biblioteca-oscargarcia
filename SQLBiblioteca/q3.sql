select book.title from book 
where book.id in (
    select checkout_item.book_id
    from checkout_item
)
union
select movie.title from movie 
where movie.id in (
    select checkout_item.movie_id
    from checkout_item
);