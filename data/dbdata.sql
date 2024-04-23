INSERT INTO public.role(
	roleid, name, description, creationdate)
	VALUES (1, 'Administrator', 'Admin Role', CURRENT_TIMESTAMP);
	
INSERT INTO public.club(
	clubid, name, isactive, creationdate)
	VALUES (1, 'Test Club', true, CURRENT_TIMESTAMP);
	
INSERT INTO public.team(
	teamid, clubclubid, name, isactive, creationdate)
	VALUES (1, 1, 'Test Team', true, CURRENT_TIMESTAMP);
	
INSERT INTO public.user(
	userid, roleroleid, teamteamid, name, email, password, gender, age, height, weight, isactive, registerdate)
	VALUES (1, 1, 1, 'Manuel Joaquim', 'mj@gmal.com', '1234', 'Male', '35', '185', '84', true, CURRENT_TIMESTAMP);