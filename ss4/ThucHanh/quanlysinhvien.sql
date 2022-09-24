select Address, count(StudentId) as 'So luong hoc vien' from student group by Address;

select s.StudentId, s.StudentName, avg(Mark) 
from student s join mark m on s.StudentId=m.StudentId
group by s.StudentId, m.StudentId;

select s.StudentId, s.StudentName, avg(Mark) 
from student s join mark m on s.StudentId=m.StudentId
group by s.StudentId, m.StudentId
having avg(Mark) > 15;

select s.StudentId, s.StudentName, avg(Mark) 
from student s join mark m on s.StudentId=m.StudentId
group by s.StudentId, m.StudentId
having avg(Mark) >= all (select avg(Mark) from mark group by Mark.StudentId);

-- hien thi thong tin mon hoc co credit lon nhat
select SubId, SubName, max(Credit), Status 
from subject; 

-- hien thi thong tin mon hoc co diem thi lon nhat
select s.SubId, s.SubName, max(m.Mark)
from subject s join mark m on s.SubId=m.SubId;

-- hien thi thong tin sinh vien voi diem trung binh theo thu tu giam dan
select s.StudentId, s.StudentName, avg(Mark) 
from student s join mark m on s.StudentId=m.StudentId
group by s.StudentId, m.StudentId
order by avg(Mark) desc;