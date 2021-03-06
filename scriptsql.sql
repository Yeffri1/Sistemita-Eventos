USE [SistemaEventos]
GO
/****** Object:  StoredProcedure [dbo].[Actualizar_Eventos]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[Actualizar_Eventos]
@IdEvento as int,@Ubicacion as nvarchar(100),@Nombre as nvarchar(50),
@Fecha as datetime,@Tipo as nvarchar(50),@resultado as int output
as
begin try
Begin Tran Principal
if(@IdEvento in(Select IdEventos from dbo.Eventos where IdEventos=@IdEvento))
begin
Update dbo.Eventos set Ubicacion=@Ubicacion,Nombre=@Nombre,Fecha=@Fecha,Tipo=@Tipo
where IdEventos=@IdEvento
set @resultado=@@ROWCOUNT
Commit tran Principal
end
end try
begin catch
Rollback TRAN Principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Actualizar_Invitaciones]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[Actualizar_Invitaciones]
@IdInvitacion as int,@IdInvitado as int,@IdEvento as int,@resultado as int output
as
begin try
begin tran principal
if(@IdInvitado IN(Select IdInvitados From Invitados where IdInvitados=@IdInvitado)
and @IdEvento in(Select IdEventos from Eventos where IdEventos=@IdEvento)
)
begin
Update dbo.Invitaciones set IdInvitado=@IdInvitado,IdEvento=@IdEvento
where IdInvitaciones=@IdInvitacion
set @resultado=@@ROWCOUNT
commit tran principal
end

end try
begin catch
rollback tran principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Actualizar_Invitado]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Actualizar_Invitado]
@IdPersona as int,@Nombre as nvarchar(50),@Apellido as nvarchar(50),@DescripcionDireccion as nvarchar(100),
@Sexo as char(1),@Email as nvarchar(100),@resultadox as int output
as
declare @aux as int=0;
Begin try
Begin tran Principal
EXEC Actualizar_Personas @IdPersona,@Nombre,@Apellido,@DescripcionDireccion,@resultado=@aux output
if(@@ERROR=0)
begin
Update Invitados set Sexo=@Sexo,Email=UPPER(@Sexo)
WHERE IdPersona=@IdPersona
set @resultadox=@@ROWCOUNT
IF(@@ERROR=0)
BEGIN
Commit tran Principal
return
END
end
end try
Begin catch
Deshacer:
Rollback tran Principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Actualizar_Personas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Actualizar_Personas]
@IdPersona as int,@Nombre as nvarchar(50),@Apellido as nvarchar(50),
@DescripcionDireccion as nvarchar(100),@resultado as int output
 as
begin try
Begin tran i

Update Personas set NombrePersona=@Nombre,Apellido=@Apellido,Descripcion_direccion=@DescripcionDireccion
where IdPersonas=@IdPersona
set @resultado=@@ROWCOUNT

if(@@ERROR=0)
BEGIN
Commit tran i
return
END
end try
begin catch
Rollback tran i
end catch

GO
/****** Object:  StoredProcedure [dbo].[Actualizar_Usuario]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Actualizar_Usuario]
@IdPersona as int,@Nombre as nvarchar(50),@Apellido as nvarchar(50),@DescripcionDireccion as nvarchar(100),
@Usuario as nvarchar(50),@Contra as nvarchar(50),@rol as nvarchar(30),@resultado as int output
as
Begin try
Begin tran Principal
EXEC Actualizar_Personas @IdPersona,@Nombre,@Apellido,@DescripcionDireccion,@resultado=@resultado output
set @resultado=0;
if(@@ERROR=0)
begin
Update Usuarios set Usuario=@Usuario,Contraseña=@Contra,Rol=@rol 
where IdPersona=@IdPersona
set @resultado = @@ROWCOUNT
IF(@@ERROR=0)
BEGIN
Commit tran Principal
return
END
end
end try
BEGIN CATCH
Rollback tran Principal
END CATCH;
GO
/****** Object:  StoredProcedure [dbo].[ejemplo]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[ejemplo]
@exito as int output,@error as nvarchar(max) output
as
begin try
insert Invitados(IdPersona,Sexo,Email)values(111,'F','DFGJDKFG');
SET @exito = @@ROWCOUNT
end try
begin catch
Set @error = ERROR_MESSAGE()
end catch

GO
/****** Object:  StoredProcedure [dbo].[Eliminar_Eventos]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[Eliminar_Eventos]
@IdEvento as int,@resultado as int output
as
begin try
begin tran Principal
Delete From dbo.Eventos where IdEventos=@IdEvento
set @resultado=@@ROWCOUNT
commit tran Principal
end try
begin catch
Rollback tran Principal
exec sp_obtenerError
end catch

GO
/****** Object:  StoredProcedure [dbo].[Eliminar_Invitaciones]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[Eliminar_Invitaciones]
@IdInvitacion as int,@resultado as int output
as
begin
Delete from Invitaciones where IdInvitaciones=@IdInvitacion
set @resultado=@@ROWCOUNT
end

GO
/****** Object:  StoredProcedure [dbo].[Eliminar_Personas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Eliminar_Personas]
@Id as int,@resultado as int output
as
begin try
BEGIN TRAN principal
Delete from Personas where IdPersonas=@Id
set @resultado=@@ROWCOUNT
commit tran principal
end try
begin catch 
rollback tran principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Calle]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[Insertar_Calle]
@IdSector as int,@Calle as nvarchar(100),@Comentario as nvarchar(100),@resultado as int output
as
begin try

if(@IdSector in(Select IdSector From Sector))
begin
Insert into Calle(IdSector,Calle,Comentario)values(@IdSector,@Calle,@Comentario)
set @resultado=@@ROWCOUNT
return
end
end try
begin catch
exec sp_obtenerError
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Eventos]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Insertar_Eventos]
@Ubicacion as nvarchar(100),@Nombre as nvarchar(50),
@Fecha as datetime,@Tipo as nvarchar(50),@resultado as int output
as
begin try
Begin Tran Principal

Insert into dbo.Eventos(Ubicacion,Nombre,Fecha,Tipo)
values(@Ubicacion,@Nombre,@Fecha,@Tipo)
set @resultado=@@ROWCOUNT

Commit tran Principal
RETURN
end try
begin catch
Rollback TRAN Principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Invitaciones]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Insertar_Invitaciones]
@IdInvitado as int,@IdEvento as int,@resultado as int output
as
begin try
Begin tran principal
Declare @fecha_evento as datetime = (Select Fecha From dbo.Eventos where IdEventos=@IdEvento)
if(@IdInvitado IN(Select IdInvitados From Invitados where IdInvitados=@IdInvitado)
and @IdEvento in(Select IdEventos from Eventos where IdEventos=@IdEvento)
)
begin
Insert into dbo.Invitaciones(IdInvitado,IdEvento,Fecha)VALUES(@IdInvitado,@IdEvento,GETDATE())
set @resultado=@@ROWCOUNT
commit tran principal
end
end try
begin catch
rollback tran principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Invitado]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Insertar_Invitado]
@Nombre as nvarchar(50),@Apellido as nvarchar(50),@DescripcionDireccion as nvarchar(100),
@Sexo as char(1),@Email as nvarchar(100),@resultado as int output
as
Declare @id_nuevo as int;
Begin try
Begin tran Principal
EXEC Insertar_Personas @Nombre,@Apellido,@DescripcionDireccion,@id_new=@id_nuevo output

if(@@ERROR=0)
begin
Insert into Invitados(IdPersona,Sexo,Email)VALUES(@id_nuevo,UPPER(@Sexo),@Email)
set @resultado=@@ROWCOUNT
IF(@@ERROR=0)
BEGIN
Commit tran Principal
return
END
end
end try
Begin catch
Deshacer:
Rollback tran Principal
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Personas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Insertar_Personas]
@Nombre as nvarchar(50),@Apellido as nvarchar(50),@DescripcionDireccion as nvarchar(100),
@id_new  as int output
 as
begin try
Begin tran i
Insert into Personas(NombrePersona,Apellido,Descripcion_direccion)values(@Nombre,@Apellido,@DescripcionDireccion)

if(@@ERROR=0)
BEGIN
seT @id_new=@@IDENTITY
Commit tran i
RETURN
END
end try
begin catch
Rollback tran i
end catch

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Usuario]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Insertar_Usuario]
@Nombre as nvarchar(50),@Apellido as nvarchar(50),@DescripcionDireccion as nvarchar(100),
@Usuario as nvarchar(50),@Contra as nvarchar(50),@rol as nvarchar(30),@resultado as int output
as
Declare @id_nuevo as int;
Begin try
Begin tran Principal
EXEC Insertar_Personas @Nombre,@Apellido,@DescripcionDireccion,@id_new=@id_nuevo output

if(@@ERROR=0)
begin
Insert into Usuarios(IdPersona,Usuario,Contraseña,Rol)VALUES(@id_nuevo,@Usuario,@Contra,@rol)
set @resultado=@@ROWCOUNT
IF(@@ERROR=0)
BEGIN
Commit tran Principal
return
END
end
end try
BEGIN CATCH
Rollback tran Principal
END CATCH;

GO
/****** Object:  StoredProcedure [dbo].[Insertar_Visitas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Insertar_Visitas]
@IdInvitacion as int,@resultado as int output
as
BEGIN TRY
BEGIN TRAN principal
if(@IdInvitacion in(Select Distinct i.IdInvitaciones From Invitaciones as i))
BEGIN
Insert into dbo.Visitas(IdInvitacion,Fecha)values(@IdInvitacion,GETDATE())
set @resultado=@@ROWCOUNT
commit tran principal
END
END TRY
BEGIN CATCH
rollback tran principal
END CATCH

GO
/****** Object:  StoredProcedure [dbo].[sp_obtenerError]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create PROCEDURE [dbo].[sp_obtenerError]
AS
   	BEGIN
        print 'El numero del error es '+ Convert(Varchar(50), ERROR_NUMBER())
        print'El error Severo es '+Convert(Varchar(5), ERROR_SEVERITY())
        print'El estado del error es '+ Convert(Varchar(5), ERROR_STATE())
        print'El procedimiento de almacenado con error es '+ Convert(Varchar(30),ERROR_PROCEDURE())
        print'La linea donde se encuentra el error es '+Convert(Varchar(5), ERROR_LINE())
        print'Mensaje de Error '+ Convert(Varchar(200),ERROR_MESSAGE());
		END

GO
/****** Object:  Table [dbo].[Eventos]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Eventos](
	[IdEventos] [int] IDENTITY(1,1) NOT NULL,
	[Ubicacion] [nvarchar](100) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[Fecha] [datetime] NOT NULL,
	[Tipo] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__Eventos__E1DD94105F485774] PRIMARY KEY CLUSTERED 
(
	[IdEventos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invitaciones]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invitaciones](
	[IdInvitaciones] [int] IDENTITY(1,1) NOT NULL,
	[IdInvitado] [int] NOT NULL,
	[IdEvento] [int] NOT NULL,
	[Fecha] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInvitaciones] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invitados]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Invitados](
	[IdInvitados] [int] IDENTITY(1,1) NOT NULL,
	[IdPersona] [int] NOT NULL,
	[Sexo] [char](1) NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInvitados] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Personas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personas](
	[IdPersonas] [int] IDENTITY(1,1) NOT NULL,
	[NombrePersona] [nvarchar](50) NOT NULL,
	[Apellido] [nvarchar](50) NOT NULL,
	[Descripcion_direccion] [nvarchar](100) SPARSE  NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPersonas] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[IdUsuarios] [int] IDENTITY(1,1) NOT NULL,
	[IdPersona] [int] NOT NULL,
	[Usuario] [nvarchar](50) NOT NULL,
	[Contraseña] [nvarchar](50) NOT NULL,
	[Rol] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUsuarios] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Visitas]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Visitas](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[IdInvitacion] [int] NOT NULL,
	[Fecha] [datetime] NULL,
 CONSTRAINT [PK_Visitas] PRIMARY KEY CLUSTERED 
(
	[IdVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[CantidaPersonaXevento]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE VIEW [dbo].[CantidaPersonaXevento]
   as
   Select Nombre,Count(*) as Cantida From Visitas
   Join Invitaciones on Invitaciones.IdInvitaciones=Visitas.IdInvitacion
   join Eventos on Invitaciones.IdEvento=Eventos.IdEventos
   group by Nombre

GO
/****** Object:  View [dbo].[DiasDelaSemanaMejores]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE view [dbo].[DiasDelaSemanaMejores]  
as
Select  case DATENAME(weekday,e.Fecha)
when 'Monday' then 'Lunes'
when 'Tuesday' then 'Martes'
when 'Wednesday' then 'Miercoles'
when 'Thursday' then 'Jueves'
when 'Friday' then 'Viernes'
when 'Saturday' then 'Sabado'
when 'Sunday' then 'Domingo'
else 'Error'
end as "Dias de Eventos",Count(v.IdVisita) as "Cantidad Visitantes"
From dbo.Eventos as e
inner join dbo.Visitas as v on 
e.IdEventos=v.IdEvento
group by v.IdEvento,DATENAME(weekday,e.Fecha)

GO
/****** Object:  View [dbo].[EventosHoy]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[EventosHoy] with schemabinding
as
Select e.IdEventos as Id,e.Nombre as Evento,e.Tipo as Tipo,e.Ubicacion as Direccion From dbo.Eventos as e
where DATEDIFF(day,e.Fecha,GETDATE())=0

GO
/****** Object:  View [dbo].[EventosMasVisitados]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE VIEW [dbo].[EventosMasVisitados]
   as
   Select Top(5) Nombre,Count(*) as Cantida From Visitas
   Join Invitaciones on Invitaciones.IdInvitaciones=Visitas.IdInvitacion
   join Eventos on Invitaciones.IdEvento=Eventos.IdEventos
   
   group by Nombre
   order by Cantida desc

GO
/****** Object:  View [dbo].[EventosProximos]    Script Date: 26/10/2017 10:04:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE view [dbo].[EventosProximos] with schemabinding
as
Select e.Nombre as Evento,e.Tipo as Tipo,e.Ubicacion as Direccion From dbo.Eventos as e
where DATEDIFF(day,GETDATE(),e.Fecha)>0


GO
ALTER TABLE [dbo].[Invitaciones] ADD  CONSTRAINT [dffechax]  DEFAULT (getdate()) FOR [Fecha]
GO
ALTER TABLE [dbo].[Visitas] ADD  CONSTRAINT [dffecha]  DEFAULT (getdate()) FOR [Fecha]
GO
ALTER TABLE [dbo].[Invitaciones]  WITH CHECK ADD  CONSTRAINT [FK_Invitaciones_Eventos] FOREIGN KEY([IdEvento])
REFERENCES [dbo].[Eventos] ([IdEventos])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Invitaciones] CHECK CONSTRAINT [FK_Invitaciones_Eventos]
GO
ALTER TABLE [dbo].[Invitaciones]  WITH CHECK ADD  CONSTRAINT [FK_Invitaciones_Invitados] FOREIGN KEY([IdInvitado])
REFERENCES [dbo].[Invitados] ([IdInvitados])
GO
ALTER TABLE [dbo].[Invitaciones] CHECK CONSTRAINT [FK_Invitaciones_Invitados]
GO
ALTER TABLE [dbo].[Invitados]  WITH CHECK ADD  CONSTRAINT [FK_Invitados_Personas] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Personas] ([IdPersonas])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Invitados] CHECK CONSTRAINT [FK_Invitados_Personas]
GO
ALTER TABLE [dbo].[Usuarios]  WITH CHECK ADD  CONSTRAINT [FK_Usuarios_Personas] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Personas] ([IdPersonas])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Usuarios] CHECK CONSTRAINT [FK_Usuarios_Personas]
GO
ALTER TABLE [dbo].[Visitas]  WITH CHECK ADD  CONSTRAINT [FK_Visitas_Invitaciones] FOREIGN KEY([IdInvitacion])
REFERENCES [dbo].[Invitaciones] ([IdInvitaciones])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Visitas] CHECK CONSTRAINT [FK_Visitas_Invitaciones]
GO
ALTER TABLE [dbo].[Invitados]  WITH CHECK ADD CHECK  (([Sexo]='M' OR [Sexo]='F'))
GO
ALTER TABLE [dbo].[Usuarios]  WITH CHECK ADD CHECK  (([Rol]='Administrador' OR [Rol]='Portero'))
GO
