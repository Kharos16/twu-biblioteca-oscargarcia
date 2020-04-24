select member_id
from checkout_item
group by member_id
having count(member_id) > 1;

select member.name from member 
where member.id in (1,6);