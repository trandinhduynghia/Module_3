select * from student where StudentName like 'H%';

select * from class where month(StartDate) = 12;

select * from subject where Credit between 3 and 5;

SET SQL_SAFE_UPDATES = 0;
update student set ClassId = '2' where StudentName = 'Hung';

select S.StudentName, Sub.SubName, M.Mark
from Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
order by M.Mark desc;

select student.StudentName, mark.Mark
from student, mark where student.StudentId=mark.StudentId;