CREATE TABLE [dbo].[class12] (
    [Name]       VARCHAR (10) NOT NULL,
    [Roll_No]    INT          NULL,
    [Email]      VARCHAR (10) NULL,
    [Mobile_No.] BIGINT       NULL
);


GO
CREATE CLUSTERED INDEX [ClusteredIndex-20230130-144155]
    ON [dbo].[class12]([Name] ASC, [Roll_No] ASC, [Email] ASC, [Mobile_No.] ASC);

