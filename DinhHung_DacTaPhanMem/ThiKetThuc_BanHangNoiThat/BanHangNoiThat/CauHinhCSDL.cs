using Microsoft.Data.SqlClient;

namespace BanHangNoiThat;

/// <summary>
/// Sửa chuỗi này nếu SQL Server không chạy ở instance mặc định localhost.
/// </summary>
internal static class CauHinhCSDL
{
    public const string ChuoiKetNoi =
        "Server=localhost;Database=BanHangNoiThat;Trusted_Connection=True;TrustServerCertificate=True;Encrypt=True;";

    public static SqlConnection Mo()
    {
        var ketNoi = new SqlConnection(ChuoiKetNoi);
        ketNoi.Open();
        return ketNoi;
    }
}
